package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Dao.User;
import com.example.demo.Service.Thread.AddThread;
import com.example.demo.Service.Thread.Counter;
import com.example.demo.Service.Thread.DecThread;
import com.example.demo.Service.Thread.Task;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author fangjiulin
 * @date 2024/1/14 22:00
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    private static Logger logger = LoggerFactory.getLogger(ThreadController.class);

    /**
     * 测试通过创建thread线程
     */
    @GetMapping("/test1")
    public void test1() {
        logger.info("通过thread创建线程");
        Thread t = new MyThread();
        t.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("start new thread!");
        }
    }

    @GetMapping("/test2")
    public void test2() {
        logger.info("通过thread创建线程");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("thread end.");
            //System.out.println(Thread.currentThread().getName() + "start new thread!");
        });
        t.start();
        try {
            System.out.println("main start...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("main end...");
    }

    @GetMapping("/test3")
    public void test3() throws InterruptedException {
        Thread t = new MyThread();
        System.out.println("start");
        t.start();
        t.join();
        System.out.println("线程执行结束");
    }

    /**
     * 线程同步,两个线程同时操作一个变量
     */
    @GetMapping("/test4")
    public int test4() throws InterruptedException {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
        return Counter.count;
    }

    /**
     * 使用线程池,固定线程池大小
     */
    @GetMapping("/test5")
    public void test5() {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
    }

    /**
     * 使用线程池,动态调整线程池大小
     */
    @GetMapping("/test6")
    public void test6() {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
    }

    /**
     * 使用ScheduledThreadPool
     */
    @GetMapping("/test7")
    public void test7() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        //ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 1, TimeUnit.SECONDS);
    }

    /**
     *
     */
    @GetMapping("/test8")
    public void test8() {

    }


}
