package com.example.demo.Service.Thread;

/**
 * @author fangjiulin
 * @date 2024/1/16 21:13
 */
public class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock){
                Counter.count -= 1;
            }

        }
    }
}
