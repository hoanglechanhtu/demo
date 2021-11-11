package com.example.demo.concurrency;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Pool pool = new Pool();
        Runnable r = () -> {
            String name = Thread.currentThread().getName();
            try
            {
                while (true)
                {
                    String item;
                    System.out.println(name + " acquiring " +
                            (item = pool.getItem()));
                    Thread.sleep(200 +
                            (int) (Math.random() * 100));
                    System.out.println(name + " putting back " +
                            item);
                    pool.putItem(item);
                }
            }
            catch (InterruptedException ie)
            {
                System.out.println(name + "interrupted");
            }
        };
        ExecutorService[] executors =
                new ExecutorService[Pool.MAX_AVAILABLE + 1];
        for (int i = 0; i < executors.length; i++)
        {
            executors[i] = Executors.newSingleThreadExecutor();
            executors[i].execute(r);
        }
    }
}

final class Pool
{
    public static final int MAX_AVAILABLE = 10;

    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    private final String[] items;

    private final boolean[] used = new boolean[MAX_AVAILABLE];

    Pool()
    {
        items = new String[MAX_AVAILABLE];
        for (int i = 0; i < items.length; i++)
            items[i] = "I" + i;
    }

    String getItem() throws InterruptedException
    {
        available.acquire();
        return getNextAvailableItem();
    }

    void putItem(String item)
    {
        if (markAsUnused(item))
            available.release();
    }

    private synchronized String getNextAvailableItem()
    {
        for (int i = 0; i < MAX_AVAILABLE; ++i)
        {
            if (!used[i])
            {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    private synchronized boolean markAsUnused(String item)
    {
        for (int i = 0; i < MAX_AVAILABLE; ++i)
        {
            if (item.equals(items[i]))
            {
                if (used[i])
                {
                    used[i] = false;
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
}
