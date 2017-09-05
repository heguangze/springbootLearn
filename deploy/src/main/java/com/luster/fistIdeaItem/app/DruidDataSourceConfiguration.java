//package com.luster.fistIdeaItem.app;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by dell on 2017-8-16.
// * http://localhost:9099/druid/index.html
// */
//@Configuration
//public class DruidDataSourceConfiguration {
//    /**
//     * 注册DruidServlet
//     *
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean druidServletRegistrationBean() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(new StatViewServlet());
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 注册DruidFilter拦截
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean duridFilterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        Map<String, String> initParams = new HashMap<String, String>();
//        //设置忽略请求
//        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
//        filterRegistrationBean.setInitParameters(initParams);
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }
//
//    /**
//     * 配置DataSource
//     * @return
//     * @throws SQLException
//     */
//    @Bean
//    public DataSource druidDataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("111111");
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/cmv3_1_local");
//        druidDataSource.setMaxActive(100);
//        druidDataSource.setFilters("stat,wall");
//        druidDataSource.setInitialSize(10);
//        return druidDataSource;
//    }
//}
