package com.example.mybatis.configuration;

import com.example.mybatis.DataSourceMonitoring;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.sql.DataSource;
import java.lang.management.ManagementFactory;

@Configuration
public class DatasourceConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"));

        return sessionFactory.getObject();
    }

}


