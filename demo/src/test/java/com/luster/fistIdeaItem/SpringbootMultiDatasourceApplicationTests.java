package com.luster.fistIdeaItem;

import com.luster.fistIdeaItem.app.AppApplication;
import com.luster.fistIdeaItem.primary.dao.IUserRepository;
import com.luster.fistIdeaItem.primary.entity.User;
import com.luster.fistIdeaItem.secondary.dao.IPersonRepository;
import com.luster.fistIdeaItem.secondary.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 多数据源测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootMultiDatasourceApplicationTests {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IPersonRepository iPersonRepository;
    @Test
    public void testSave() throws Exception {
        List<User> userList=iUserRepository.findAll();
        List<Person> personList=iPersonRepository.findAll();
    }

    @Test
    public void contextLoads() {
    }

}
