package com.example.demo.Service.simpleFactory;

import com.example.demo.api.simpleFactory.Human;

/**
 * @author fangjiulin
 * @date 2024/1/13 18:11
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
