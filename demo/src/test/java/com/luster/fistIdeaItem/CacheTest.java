//package com.luster.fistIdeaItem;
//
//import com.luster.fistIdeaItem.app.AppApplication;
//import com.luster.fistIdeaItem.primary.entity.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * Created by dell on 2018-2-1.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CacheTest {
//    @Autowired
//    private CacheManager cacheManager;
//
//    @Test
//    public void userCacheTest() {
//        Cache userCache = cacheManager.getCache("user");
//        User user = new User();
//        user.setName("luser");
//        user.setAge(25);
//        userCache.put("luster", user);
//        System.out.println(userCache.get("luster", User.class).getName());
//    }
//}
