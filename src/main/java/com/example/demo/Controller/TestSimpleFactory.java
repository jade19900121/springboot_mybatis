package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Dao.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试简单工厂方法
 * @author fangjiulin
 * @date 2024/1/11 23:09
 */
@RestController
@RequestMapping("/testSimpleFactory")
public class TestSimpleFactory {
    @PostMapping("/test1")
    public void getHuman() {
    }

}
