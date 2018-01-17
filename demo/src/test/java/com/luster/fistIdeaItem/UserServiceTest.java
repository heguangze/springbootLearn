package com.luster.fistIdeaItem;

import com.luster.fistIdeaItem.app.AppApplication;

import com.luster.fistIdeaItem.dao.IRoleRepository;
import com.luster.fistIdeaItem.entity.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.luster.fistIdeaItem.dao.IUserRepository;
import com.luster.fistIdeaItem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2017-9-5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IRoleRepository iRoleRepository;

    @Autowired
    private CacheManager cacheManager;

//    @Before
//    public void before(){
//        iUserRepository.deleteAll();
//    }
//
//    @After
//    public void after(){
//        iUserRepository.deleteAll();
//    }

    @Test
    public void testAddUser() {
        Role role=new Role();
        role.setName("管理员");
        iRoleRepository.save(role);

        User user = new User();
        user.setName("luser");
        user.setAge(25);
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        iUserRepository.save(user);
        Cache userCache = cacheManager.getCache("user");
        userCache.put("luster", user);
        System.out.println(userCache.get("luster", User.class).getAge());
    }


}
