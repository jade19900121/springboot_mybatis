package com.example.demo.Service.simpleFactory;

import com.example.demo.api.simpleFactory.Human;

/**
 * @author fangjiulin
 * @date 2024/1/13 18:11
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄土地的颜色!");
    }

    @Override
    public void talk() {
        System.out.println("五湖四海皆兄弟！");
    }
}
