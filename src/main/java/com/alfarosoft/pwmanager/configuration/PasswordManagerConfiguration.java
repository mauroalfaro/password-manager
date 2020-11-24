package com.alfarosoft.pwmanager.configuration;

import com.alfarosoft.pwmanager.database.HibernateSessionFactory;
import com.alfarosoft.pwmanager.service.PasswordManagerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class PasswordManagerConfiguration {

    @Bean
    @RequestScope
    public PasswordManagerService passwordManagerService() throws Exception {
        return new PasswordManagerService(hibernateSessionFactory());
    }

    @Bean
    @RequestScope
    public HibernateSessionFactory hibernateSessionFactory(){
        return new HibernateSessionFactory();
    }
}
