package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Dao.User;
import com.example.demo.Service.simpleFactory.HumanFactory;
import com.example.demo.Service.simpleFactory.WhiteHuman;
import com.example.demo.api.simpleFactory.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @author fangjiulin
 * @date 2024/1/13 18:24
 */
@RestController
@RequestMapping("/simpleFactory")
public class SimpleFactoryController {
    private static Logger logger = LoggerFactory.getLogger(SimpleFactoryController.class);

    @PostMapping("/test1")
    public void createHuman() {
        logger.info("现在通过简单工厂创造实例");
        Human human = HumanFactory.createHuman(WhiteHuman.class);
        human.getColor();
        human.talk();
    }
}
