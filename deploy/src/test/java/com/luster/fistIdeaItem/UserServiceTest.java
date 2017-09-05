package com.luster.fistIdeaItem;

import com.luster.fistIdeaItem.app.AppApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.luster.fistIdeaItem.dao.IUserRepository;
import com.luster.fistIdeaItem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * Created by dell on 2017-9-5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    IUserRepository iUserRepository;

    @Test
    public void testAddUser(){
        User user=new User();
        user.setName("luser");
        user.setAge(25);
        iUserRepository.save(user);
    }

}
