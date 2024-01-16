package com.example.demo.Controller;

import com.example.demo.Dao.Person;
import com.example.demo.Service.simpleFactory.HumanFactory;
import com.example.demo.Service.simpleFactory.WhiteHuman;
import com.example.demo.api.simpleFactory.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试集合
 *
 * @author fangjiulin
 * @date 2024/1/15 23:03
 */
@RestController
@RequestMapping("/gather")
public class GatherController {
    private static Logger logger = LoggerFactory.getLogger(GatherController.class);

    /**
     * 使用list
     */
    @GetMapping("/test1")
    public void test1() {
        logger.info("使用list");
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        list.add(null);
        System.out.println(list.size());
        String second = list.get(3);
        System.out.println(second);
    }

    /**
     * 使用for循环遍历list
     */
    @GetMapping("/test2")
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        list.add(null);
        for (String i : list) {
            System.out.println(i);
        }

    }


    /**
     * 编写equals方法
     */
    @GetMapping("/test3")
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.contains("C"));
        System.out.println(list.contains("X"));
        System.out.println(list.indexOf("C"));
        System.out.println(list.indexOf("X"));
    }

    @GetMapping("/test4")
    public void test4() {
        List<Person> list = new ArrayList<>();
        Person person1 = new Person();
        person1.setName("a");
        list.add(person1);
        Person person2 = new Person();
        person1.setName("b");
        list.add(person2);
        Person person3 = new Person();
        person3.setName("c");
        list.add(person3);
        for (Person person : list) {
            System.out.println(person.hashCode());
        }
        //判断集合是否包含person1
        System.out.println(list.contains(person1));
        Person person4 = new Person();
        person1.setName("a");
        System.out.println(list.contains(person4));

    }

}
