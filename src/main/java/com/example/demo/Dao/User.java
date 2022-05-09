package com.example.demo.Dao;

import lombok.Data;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 上午 9:56
 */
@Data
public class User {
    /**
     * 主键id
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

}
