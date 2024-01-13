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
    public void lazySingleton() {
        logger.info("现在测试单例懒汉式");
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton.hashCode());
    }
}
