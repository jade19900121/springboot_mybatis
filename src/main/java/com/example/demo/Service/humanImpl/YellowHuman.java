package com.example.demo.Service.humanImpl;

import com.example.demo.api.human.Human;

/**
 * @author fangjiulin
 * @date 2024/1/11 23:16
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄土地的颜色!");
    }

    @Override
    public void talk() {
        System.out.println("五湖四海皆兄弟!");
    }
}
