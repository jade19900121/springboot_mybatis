package com.example.demo.Service.simpleFactory;

import com.example.demo.api.simpleFactory.Human;

/**
 * @author fangjiulin
 * @date 2024/1/13 18:10
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的！");
    }

    @Override
    public void talk() {
        System.out.println("Hey!Man.");
    }
}
