package com.luster.fistIdeaItem.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Created by dell on 2017-8-16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.luster.fistIdeaItem.*"})
@EntityScan(basePackages = {"com.luster.fistIdeaItem.entity"})
@EnableJpaRepositories(basePackages = "com.luster.fistIdeaItem.dao")
@EnableCaching
public class AppApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppApplication.class, args);
    }

}
