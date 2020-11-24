package com.alfarosoft.pwmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.alfarosoft.pwmanager")
public class PasswordManagerApp {

    public static void main(String[] args){
        SpringApplication.run(PasswordManagerApp.class, args);
    }
}
