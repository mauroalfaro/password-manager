package com.alfarosoft.pwmanager;

import com.alfarosoft.pwmanager.service.PasswordManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@SpringBootApplication
@ComponentScan("com.alfarosoft.pwmanager")
public class PasswordManagerApp {
    private static PasswordManagerService passwordManagerService;

    private static String WELCOME_MESSAGE = "Basic Password Manager";
    private static String SEPARATOR = "-------------------------";
    private static String INSERT_USERNAME = "Please type your user name: ";
    private static String INSERT_PASSWORD = "Please type your password: ";
    private static String SELECT_OPTION = "Select option";

    public static void main(String[] args){
        SpringApplication.run(PasswordManagerApp.class, args);

        System.out.println(WELCOME_MESSAGE);
        System.out.println(SEPARATOR);

        System.out.println(INSERT_USERNAME);
        String name = System.console().readLine();

        System.out.println(INSERT_PASSWORD);
        String password = System.console().readLine();

        passwordManagerService.lookupUser(name, password);

    }
}
