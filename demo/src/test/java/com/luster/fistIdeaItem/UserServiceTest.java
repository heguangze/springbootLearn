package com.luster.fistIdeaItem;

import com.luster.fistIdeaItem.app.AppApplication;

import com.luster.fistIdeaItem.primary.dao.IRoleRepository;
import com.luster.fistIdeaItem.primary.entity.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.luster.fistIdeaItem.primary.dao.IUserRepository;
import com.luster.fistIdeaItem.primary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2017-9-5.
 */
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IRoleRepository iRoleRepository;



    @Before
    public void before(){
        iUserRepository.deleteAll();
    }

    @After
    public void after(){
//        iUserRepository.deleteAll();
    }

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
    }

}
