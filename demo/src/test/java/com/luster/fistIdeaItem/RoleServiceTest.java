package com.luster.fistIdeaItem;

import com.luster.fistIdeaItem.app.AppApplication;
import com.luster.fistIdeaItem.dao.IRoleRepository;
import com.luster.fistIdeaItem.dao.IUserRepository;
import com.luster.fistIdeaItem.entity.Role;
import com.luster.fistIdeaItem.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class RoleServiceTest {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IRoleRepository iRoleRepository;


    @Before
    public void before() {
//        iRoleRepository.deleteAll();
    }

    @After
    public void after() {
//        iRoleRepository.deleteAll();
    }

    @Test
    public void testRole() {
        User user = new User();
        user.setName("luser");
        user.setAge(25);
        iUserRepository.save(user);
        Role role = new Role();
        role.setName("管理员");
        Set<User> users = new HashSet<>();
        users.add(user);
        role.setUsers(users);
        iRoleRepository.save(role);

//        User oldUser = iUserRepository.findOne(user.getId());
//        System.out.println(oldUser.getRoles());//测试模式，无法懒加载
    }

    @Test
    public void deleteAll() {
        iRoleRepository.deleteAllInBatch();
    }

}
