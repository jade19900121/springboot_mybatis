package com.example.demo.Controller;

import com.example.demo.Service.Singleton.HungrySingleton;
import com.example.demo.Service.Singleton.LazySingleton;
import com.example.demo.Service.simpleFactory.HumanFactory;
import com.example.demo.Service.simpleFactory.WhiteHuman;
import com.example.demo.api.simpleFactory.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fangjiulin
 * @date 2024/1/13 19:11
 */
@RestController
@RequestMapping("/singleton")
public class SingletonController {
    private static Logger logger = LoggerFactory.getLogger(SingletonController.class);

    @GetMapping("/test1")
    public void hungrySingleton() {
        logger.info("现在测试单例饿汉式");
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton.hashCode());
    }

    @GetMapping("/test2")
    public String lazySingleton() throws InterruptedException {
        logger.info("现在测试单例懒汉式-并发下线程不安全");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        //用这个list多线程会有问题
        //List<String> list1 = new ArrayList<>();
        //改成下面的list可以避免ConcurrentModificationException
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list1.add(Thread.currentThread().getName() + "===" + LazySingleton.getInstance() + "<br>");
                    System.out.println(Thread.currentThread().getName() + "===" + LazySingleton.getInstance());
                   latch.countDown();
                }
            });
        }
        latch.await();
        executorService.shutdown();
        return list1.toString();
    }

    @GetMapping("/test3")
    public void lazySingleton1() throws InterruptedException {
        logger.info("现在测试单例懒汉式-并发下线程不安全,创建出来了多个实例");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "===" + LazySingleton.getInstance());
                }
            });
        }
        executorService.shutdown();
    }

    @GetMapping("/test4")
    public void hungrySingleton1() throws InterruptedException {
        logger.info("\n现在测试单例饿汉式-并发下线程安全,有且仅有一个实例");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "===" + HungrySingleton.getInstance());
                }
            });
        }
        executorService.shutdown();
    }
}
