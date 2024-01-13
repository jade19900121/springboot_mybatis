package com.example.demo.Service.Singleton;

import org.springframework.stereotype.Service;

/**
 * @author fangjiulin
 * @date 2024/1/13 19:16
 */
public class LazySingleton {
    // 创建全局静态变量，保证只有一个实例
    private static LazySingleton instance = null;

    // 构造函数私有化
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        //先判断是否存在当前类的实例
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
