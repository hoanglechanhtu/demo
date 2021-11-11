package com.example.demo.concurrency;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

@Component
public class PhaserRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> System.out.printf("%s running at %d%n",
                Thread.currentThread().getName(),
                System.currentTimeMillis()));
        tasks.add(() -> System.out.printf("%s running at %d%n",
                Thread.currentThread().getName(),
                System.currentTimeMillis()));
        runTasks(tasks);
    }

    static void runTasks(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1); // "1" (register self)
        // create and start threads
        for (final Runnable task : tasks) {
            phaser.register();
            Runnable r = () ->
            {
                try {
                    Thread.sleep(50 + (int) (Math.random() * 300));
                } catch (InterruptedException ie) {
                    System.out.println("interrupted thread");
                }
                phaser.arriveAndAwaitAdvance(); // await the ...
                // creation of ...
                // all tasks
                task.run();
            };
            Executors.newSingleThreadExecutor().execute(r);
        }
        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }
}