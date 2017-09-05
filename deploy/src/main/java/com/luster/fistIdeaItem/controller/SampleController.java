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

}
