package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.example.demo.Dao.User;
import com.example.demo.api.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 上午 9:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private static TransmittableThreadLocal<Integer> t1 = new TransmittableThreadLocal<>();
    private static TransmittableThreadLocal<Integer> t2 = new TransmittableThreadLocal<>();

    @Autowired
    private  UserService userService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        logger.info("正在添加用户信息:{}", JSON.toJSONString(user));
        return userService.addUser(user);
    }

    @ResponseBody
    @PostMapping("/search")
    public User searchById(@RequestBody User user) {
        logger.info("正在查询的用户参数是{}", JSON.toJSONString(user));
        return userService.searchById(user.getId());
    }

    @ResponseBody
    @PostMapping("/searchall")
    public List<User> searchAll() {
        return userService.searchAll();
    }
    //我的

    @ResponseBody
    @PostMapping("/testPool")
    public void testThreadPool(@Param("score1") int score1, @Param("score2") int score2) {
        long stime = System.currentTimeMillis();
        //初始化一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            score1++;
            score2++;
        }
        t1.set(score1);
        //t2.set(score2);
        System.out.println("当前主线程的变量值score1:" + score1 + "线程名:" + Thread.currentThread().getName());
        //System.out.println("当前主线程的变量值score2:" + score2 + "线程名:" + Thread.currentThread().getName());
        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(executorService);

        ttlExecutorService.submit(() -> {
            String value = t1.get().toString();
            System.out.println("Task is running in thread: " + Thread.currentThread().getName() + ", TransmittableThreadLocal value: " + value);
        });

        //子线程1
//        CompletableFuture<String> sonFuture1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(t1.get());
//            try {
//                if (t1.get() == 10) {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("子线程son1获取父线程的变量score1值是:" + t1.get());
//
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return t1.get().toString();
//        }, threadPoolTaskExecutor);

        //子线程2
//        CompletableFuture<String> sonFuture2 = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(t2.get());
//            try {
//                if (t2.get() == 20) {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("子线程son2获取父线程的变量score2值是:" + t2.get());
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return t2.get().toString();
//        }, threadPoolTaskExecutor);
//        CompletableFuture<String> results = CompletableFuture.allOf(sonFuture1, sonFuture2).thenApply(result -> {
//            sonFuture1.join();
//            sonFuture2.join();
//            String ss = null;
//            try {
//                ss = "子线程son1的值:" + sonFuture1.get() + "子线程son2的值:" + sonFuture2.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            return ss;
//        });
        System.out.println("当前主线程结束:");
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
    }
}