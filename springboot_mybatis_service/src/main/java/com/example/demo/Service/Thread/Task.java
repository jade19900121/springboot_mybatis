package com.example.demo.Service.Thread;

import java.text.SimpleDateFormat;

/**
 * @author fangjiulin
 * @date 2024/1/17 21:26
 */
public class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(Thread.currentThread().getName() + "-" + df.format(System.currentTimeMillis()) + "-start task " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "end task " + name);
    }
}
