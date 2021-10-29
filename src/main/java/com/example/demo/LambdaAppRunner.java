package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.event.TreeSelectionEvent;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class LambdaAppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Supplier<LocalDate> date1 = LocalDate::now;
        Supplier<ArrayList<String>> arrayListSupplier = ArrayList<String>::new;


        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer1 = consumer.andThen(x -> log.info("And then"));
        consumer1.accept("Hello ");
        BiConsumer<Integer, String> consumer2 = (x, y) -> log.info("Consumer {} {}", x, y);
        consumer2.accept(10, "Hi");

        Predicate<String> predicate = x -> x.equals("Hi");
        Predicate<String> eggs = x -> x.contains("eggs");
        Predicate<String> brown = x -> x.contains("brown");
        Predicate<String> brownEggs = eggs.and(brown);
        Predicate<String> notBrownEggs = eggs.and(brown.negate());
        Predicate<String> notEgg = eggs.negate();
        BiPredicate<String, Integer> predicate1 = (x, y) -> x.equals("Hi") && y == 10;
        log.info("Is brown eggs {}", brownEggs.test("browneggs"));

        Function<String, Integer> function = String::length;
        BiFunction<String, Integer, Integer> function1 = (x, y) -> x.length() + y;
        Function<String, Integer> function2 = function.andThen(x -> x + 1);
        Function<String, Integer> function3 =  function.compose(x -> "hello");

        UnaryOperator<String> unaryOperator = String::toLowerCase;
        BinaryOperator<String> binaryOperator = (x, y) -> (x + y);

        Stream<Integer> stream = Stream.empty();
        Stream<Integer> stream1 = Stream.<Integer>builder()
                .add(10)
                .add(20)
                .build();
        Stream<Integer> stream2 = Stream.of(100, 200, 300);
        List<Integer> list = Arrays.asList(10, 20, 30);
        Stream<Integer> stream3 = list.stream();
        Stream<Integer> stream4 = list.parallelStream();
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        Stream<Integer> oddNumbersLessThan100 = Stream.iterate(1, n -> n < 100, n -> n + 2);
        Stream.iterate(1, x -> x + 1).limit(5)
                .peek(x -> log.info("Number {}", x))
                .filter(x -> x % 2 != 0)
                .forEach(x -> log.info("Last {}", x));

        //long counts = randoms.count();
        Optional<Double> min = randoms.min(Comparator.comparingDouble(x -> x));
        Stream<String> stream5 = Stream.of("w", "o", "r", "l", "d");
        TreeSet<String> treeSet = stream5.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        TreeSet<String> treeSet1 = stream5.collect(Collectors.toCollection(TreeSet::new));
        Set<String> sets = stream5.collect(Collectors.toSet());

        Stream<Integer> stream6 = oddNumbers.filter(x -> x % 3 == 0);
        Stream<Double> stream7 = randoms.distinct();
        Stream<Double> stream8 = randoms.limit(100);
        Stream<Double> stream9 = randoms.skip(10);
        Stream<Integer> stream10 = randoms.limit(100).map(Double::intValue);

        List<String> zero = List.of();
        List<String> one = List.of("hi");
        List<String> two = List.of("hehe" , "haha");

        Stream<List<String>> stream11 = Stream.of(zero, one, two);
        Stream<String> stream12 = stream11.flatMap(Collection::stream);
        Stream<String> stream13 = stream12.sorted();

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        int sum = integerStream.mapToInt(x -> x).sum();
        OptionalDouble average = integerStream.mapToInt(x -> x).average();
        DoubleStream doubleStream = DoubleStream.of(1, 2, 3, 4, 5);
        DoubleStream randomDoubles = DoubleStream.generate(Math::random);
        IntStream intStream = IntStream.range(1, 5);
        IntStream intStream1 = IntStream.rangeClosed(1, 5);
        Stream<Integer> stream14 = intStream.boxed();
        Stream<Integer> stream15 = intStream.mapToObj(i -> i + 5);
        DoubleToIntFunction doubleToIntFunction =  x -> 1;
        IntStream intStream2 = randomDoubles.mapToInt(doubleToIntFunction);

        OptionalDouble optionalDouble = intStream.average();
        double doubleAsDouble = optionalDouble.getAsDouble();
        double doubleAsDouble1 = optionalDouble.orElse(5d);





    }
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }


}
