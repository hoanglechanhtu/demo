package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class ThreadAppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread thread = new CustomThread();
        thread.start();
        thread.join();
        Thread thread1 = new Thread(new CustomRunnable());
        thread1.start();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> log.info("Hello from executor"));
        Future<?> future = executor.submit(() -> log.info("Hello from executor submit"));
        Future<String> future1 = executor.submit(() -> "Hello");
        List<Callable<String>> callableList = List.of(() -> "One,", () -> "Two");
        //Both synchronously call, the program have to wait until the method is finished
        executor.invokeAll(callableList);
        executor.invokeAny(callableList);

        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(() -> log.info("Hello from schedule"), 10, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(() -> log.info("Hello again"), 10, 10, TimeUnit.SECONDS);
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(counter::inc);
        }

        List<Character> list = Arrays.asList('w', 'o', 'l', 'f');
        String combine = list.stream().reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3);

        log.info("Reduce with stream {}", combine);

        /*
        The identity must be defined such that for all elements in the stream u ,
        combiner.apply(identity, u) is equal to u .
        The accumulator operator op must be associative and stateless such that (a op b) op c
        is equal to a op (b op c) .
        The combiner operator must also be associative and stateless and compatible with the
        identity, such that for all u and t combiner.apply(u,accumulator.apply(identity,t))
        is equal to accumulator.apply(u,t) .*/
        List<Character> list2 = Arrays.asList('w', 'o', 'l', 'f');
        String combine2 = list2.stream().parallel().reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3);

        log.info("Reduce with parallel stream {}", combine);

        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add,
                Set::addAll);
        log.info("Set {}", set);

        /*
        Requirements for Parallel Reduction with collect()
        The stream is parallel.
        The parameter of the collect operation has the Collector.Characteristics.CONCURRENT
        characteristic.
                Either the stream is unordered, or the collector has the characteristic
        Collector.Characteristics.UNORDERED .
        */

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length, k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap


        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        LionPenManager lionPenManager = new LionPenManager();
        CyclicBarrier removeBarrier = new CyclicBarrier(4), cleanBarrier = new CyclicBarrier(4, () -> log.info("Done cleaning"));
        for (int i = 0; i < 4; i ++) {
            executorService1.submit(() -> lionPenManager.performTask(removeBarrier, cleanBarrier));
        }

        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new WeightAction(0, 10, weights);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task);

        ForkJoinTask<Double> forkJoinTask = new WeightTask(0, 10, weights);
        double sum = forkJoinPool.invoke(forkJoinTask);
        log.info("Sum weight = {}", sum);
    }

    //Better Object-oriented design practices
    //Better reusable
    //Can extend another class
    static class CustomRunnable implements Runnable {
        @Override
        public void run() {
            log.info("Hello from runnable");
        }
    }

    //If you need to define your own Thread rules upon which multiple tasks will rely, such
    //as a priority Thread , extending Thread may be preferable.
    static class CustomThread extends Thread {
        @Override
        public void run() {
            log.info("Hello from thread");
        }


    }

    static class Counter {
        //AtomicInteger count = new AtomicInteger(0);

        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

        Counter() {
            integerThreadLocal.set(0);
        }

        void inc() {
            // count.incrementAndGet();
            integerThreadLocal.set(integerThreadLocal.get() + 1);
        }

        int get() {
            return integerThreadLocal.get();
        }
    }

    static class LionPenManager {
        private void removeAnimals() {
            log.info("Removing animals");
        }

        private void clean() {
            log.info("Clean the pen");
        }

        private void addAnimals() {
            log.info("Adding animals");
        }

        public void performTask(CyclicBarrier removeBarrier, CyclicBarrier cleanBarrier){
            try {
                removeAnimals();
                removeBarrier.await();
                clean();
                cleanBarrier.await();
                addAnimals();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    class WeightAction extends RecursiveAction {
        int start;
        int end;
        Double[] weights;

        public WeightAction(int start, int end, Double[] weights) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected void compute() {
            if (end - start <= 3) {
                for (int i = start; i < end; i ++) {
                    weights[i] = new Random().nextDouble();
                    log.info("Animal {} weight {}", i, weights[i]);
                }
            } else {
                int middle = (start + end)/2;
                log.info("[start= {}, middle = {}, end = {}]", start, middle, end);
                invokeAll(new WeightAction(start, middle, weights), new WeightAction(middle, end, weights));
            }
        }
    }


    class WeightTask extends RecursiveTask<Double> {
        int start;
        int end;
        Double[] weights;

        public WeightTask(int start, int end, Double[] weights) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected Double compute() {
            if (end - start <= 3) {
                double sum = 0;
                for (int i = start; i < end; i ++) {
                    weights[i] = new Random().nextDouble();
                    sum += weights[i];
                    log.info("Animal {} weight {}", i, weights[i]);
                }
                return sum;
            } else {
                int middle = (start + end)/2;
                log.info("[start= {}, middle = {}, end = {}]", start, middle, end);
                RecursiveTask<Double> other = new WeightTask(start, middle, weights);
                other.fork();
                return new WeightTask(middle, end, weights).compute() + other.join();
            }
        }
    }
}
