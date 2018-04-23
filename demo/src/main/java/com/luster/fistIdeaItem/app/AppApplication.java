package com.luster.fistIdeaItem.app;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by dell on 2017-8-16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.luster.fistIdeaItem.*"})
@EntityScan(basePackages = {"com.luster.fistIdeaItem.entity"})
@EnableCaching
public class AppApplication {

    @PersistenceContext
    private EntityManager em;

    @PersistenceContext(unitName = "secondaryPersistenceUnit")
    private EntityManager emSecondary;

    @Bean
    public JPAQueryFactory jpaQueryFactorySecondary() {
        return new JPAQueryFactory(emSecondary);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppApplication.class, args);
    }


    /**
     * it's for set http url auto change to https
     */
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");//confidential
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(httpConnector());
//        return tomcat;
//    }
//
//    @Bean
//    public Connector httpConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(9098);
//        connector.setSecure(false);
//        connector.setRedirectPort(9099);
//        return connector;
//    }

}
