package com.luster.fistIdeaItem.controller;

import com.luster.fistIdeaItem.primary.dao.IUserRepository;
import com.luster.fistIdeaItem.primary.entity.QUser;
import com.luster.fistIdeaItem.primary.entity.User;
import com.luster.fistIdeaItem.secondary.dao.IPersonRepository;
import com.luster.fistIdeaItem.secondary.entity.Person;
import com.luster.fistIdeaItem.secondary.entity.QPerson;
import com.luster.fistIdeaItem.secondary.entity.QYal;
import com.luster.fistIdeaItem.secondary.entity.Yal;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dell on 2017-6-29.
 */
@RestController
public class SampleController {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IPersonRepository iPersonRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    JPAQueryFactory jpaQueryFactorySecondary;

    @RequestMapping("/get")
    @Transactional
    String home() {
        QUser qUser = QUser.user;
        User user = jpaQueryFactory.selectFrom(qUser).fetchFirst();

        QPerson qPerson = QPerson.person;
        Person person = jpaQueryFactorySecondary.selectFrom(qPerson).fetchFirst();

        QYal qYal=QYal.yal;
        Yal yal=jpaQueryFactorySecondary.selectFrom(qYal).where(qYal.jingId.eq("3")).fetchFirst();

        return yal.getJingId();
    }

//    @PostMapping("/persion/getPersion/{id}.json")
//    @ResponseBody
//    public Human getPersion(@PathVariable("id") String id) {
//        System.out.println("ID:" + id);
//        return new Human("1", "leftso", 1, "重庆.大竹林");
//    }

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
