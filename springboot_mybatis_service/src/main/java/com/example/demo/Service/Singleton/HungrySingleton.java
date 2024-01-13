package com.example.demo.Service.Singleton;

import org.springframework.stereotype.Service;

/**
 * @author fangjiulin
 * @date 2024/1/13 19:09
 */
public class HungrySingleton {

    private static volatile HungrySingleton instance  = new HungrySingleton();

    //构造函数私有化
    private HungrySingleton() {
    }

    //获取类的实例
    public static HungrySingleton getInstance() {
        return instance;
    }
}
