package com.example.demo.Service.humanImpl;

import com.example.demo.api.human.Human;

/**
 * @author fangjiulin
 * @date 2024/1/11 23:16
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白肤色");
    }

    @Override
    public void talk() {
        System.out.println("Calm down!Guy!");
    }
}
