package com.alfarosoft.pwmanager.service;

import com.alfarosoft.pwmanager.database.HibernateSessionFactory;
import com.alfarosoft.pwmanager.exception.PasswordManagerException;
import com.alfarosoft.pwmanager.model.Application;
import com.alfarosoft.pwmanager.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class PasswordManagerService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session pwSession;
    private static final Logger LOG = LoggerFactory.getLogger(PasswordManagerService.class);

    public PasswordManagerService(HibernateSessionFactory hibernateSessionFactory) throws Exception {
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.pwSession = hibernateSessionFactory.buildSession();
    }

    public User addUser (User user){
        pwSession.beginTransaction();
        pwSession.save(user);
        pwSession.getTransaction().commit();
        LOG.info("User created");
        return user;
    }

    public User lookupUser (String username, String password){
        return retrieveUserNameFromDatabase(username, password);
    }

    public Application addApplication (Application application){
        pwSession.beginTransaction();
        pwSession.save(application);
        pwSession.getTransaction().commit();
        LOG.info("Application created");
        return application;
    }

    public Application lookupApplication (String appName){
        return retrieveAppFromDatabase(appName);
    }

    public List<Application> getAllAplications (String username){
        pwSession.beginTransaction();
        List<Application> applications = pwSession.createQuery("from Application", Application.class).list();
        pwSession.getTransaction().commit();
        LOG.info("Applications returned");
        return applications;
    }

    private User retrieveUserNameFromDatabase (String username, String password){
        User userRetrieved;
        try{
            pwSession.beginTransaction();
            Query selectQuery = pwSession.createQuery("from User WHERE USERNAME=:paramUsername and PASSWORD=:paramPassword");
            selectQuery.setParameter("paramUsername", username);
            selectQuery.setParameter("paramPassword", password);
            userRetrieved = (User) selectQuery.uniqueResult();
            LOG.info("User retrieved", userRetrieved.toString());
            return userRetrieved;
        } catch (EntityNotFoundException e){
            LOG.error("Incorrect user information retrieving username: {}", username);
            throw new PasswordManagerException("User with username " + username + " was not found or user/password are incorrect", 404);
        }
    }

    private Application retrieveAppFromDatabase (String appName){
        Application appRetrieved;
        try{
            pwSession.beginTransaction();
            Query selectQuery = pwSession.createQuery("from Application WHERE APP_NAME=:paramAppName");
            selectQuery.setParameter("paramAppName", appName);
            appRetrieved = (Application) selectQuery.uniqueResult();
            LOG.info("App retrieved", appRetrieved.toString());
            return appRetrieved;
        } catch (EntityNotFoundException e){
            LOG.error("Application not found with name: {}", appName);
            throw new PasswordManagerException("Application with name " + appName + " was not found", 404);
        }
    }
}
