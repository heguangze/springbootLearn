package com.luster.fistIdeaItem.controller;

import com.luster.fistIdeaItem.dao.IUserRepository;
import com.luster.fistIdeaItem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017-6-29.
 */
@RestController
public class SampleController {

    @RequestMapping("/get")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/getJVM")
    String getJVM(){
        long maxM = Runtime.getRuntime().maxMemory();// 返回 Java 虚拟机试图使用的最大内存量
        long totalM = Runtime.getRuntime().totalMemory();//返回 Java 虚拟机中的内存总量。
        long usedM = Runtime.getRuntime().freeMemory();//返回 Java 虚拟机中的空闲内存量。
        return "maxM=" + maxM/1024/1024 + ",totalM=" + totalM/1024/1024 + ",freeM=" + usedM/1024/1024;
    }

}
