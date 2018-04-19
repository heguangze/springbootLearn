package com.luster.fistIdeaItem.controller;

import com.luster.fistIdeaItem.dao.IUserRepository;
import com.luster.fistIdeaItem.entity.Person;
import com.luster.fistIdeaItem.entity.QUser;
import com.luster.fistIdeaItem.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dell on 2017-6-29.
 */
@RestController
public class SampleController {

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @RequestMapping("/get")
    String home() {
        return "Hello World!";
    }

    @PostMapping("/persion/getPersion/{id}.json")
    @ResponseBody
    public Person getPersion(@PathVariable("id") String id) {
        System.out.println("ID:" + id);
        return new Person("1", "leftso", 1, "重庆.大竹林");
    }

    @RequestMapping("/getJVM")
    String getJVM() {
        long maxM = Runtime.getRuntime().maxMemory();// 返回 Java 虚拟机试图使用的最大内存量
        long totalM = Runtime.getRuntime().totalMemory();//返回 Java 虚拟机中的内存总量。
        long usedM = Runtime.getRuntime().freeMemory();//返回 Java 虚拟机中的空闲内存量。
        return "maxM=" + maxM / 1024 / 1024 + ",totalM=" + totalM / 1024 / 1024 + ",freeM=" + usedM / 1024 / 1024;
    }

    @RequestMapping("/getUserRoles")
    String getUserRoles() {
        QUser qUser = QUser.user;
        User user = jpaQueryFactory.selectFrom(qUser).fetchFirst();

        return user.toString();
    }

}
