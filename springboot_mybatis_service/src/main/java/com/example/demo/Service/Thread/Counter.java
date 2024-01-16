package com.example.demo.Service.Thread;

/**
 * @author fangjiulin
 * @date 2024/1/16 21:13
 */
public class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}
