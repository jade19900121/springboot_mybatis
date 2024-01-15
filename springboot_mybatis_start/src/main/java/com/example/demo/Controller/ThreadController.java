package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
        Thread t = new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "start new thread!");
        });
        t.start();
    }

}
