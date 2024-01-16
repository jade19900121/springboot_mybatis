package com.example.demo.Service.Thread;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author fangjiulin
 * @date 2024/1/16 21:12
 */
public class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}
