package com.example.demo.Service.Thread;

import java.util.concurrent.Callable;

/**
 * @author fangjiulin
 * @date 2024/1/17 22:29
 */
public class Task1 implements Callable<String> {

    private final String name;

    public Task1(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000);
            return name;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
