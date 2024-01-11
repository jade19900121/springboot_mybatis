package com.example.demo.Service.humanImpl;

import com.example.demo.api.human.Human;

/**
 * @author fangjiulin
 * @date 2024/1/11 23:16
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
