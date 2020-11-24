package com.alfarosoft.pwmanager.controller;

import com.alfarosoft.pwmanager.model.Application;
import com.alfarosoft.pwmanager.model.User;
import com.alfarosoft.pwmanager.service.PasswordManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;


@RestController
@RequestMapping(value = "/pwmanager")
public class PasswordManagerController {

    private final PasswordManagerService passwordManagerService;
    private static final Logger LOG = LoggerFactory.getLogger(PasswordManagerController.class);

    @Autowired
    public PasswordManagerController(PasswordManagerService passwordManagerService) {
        this.passwordManagerService = passwordManagerService;
    }

    @PostMapping(value = "/addUser", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(passwordManagerService.addUser(user));
    }

    @GetMapping(value = "/lookupUser/{username}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> lookupUser (@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(passwordManagerService.lookupUser(username));
    }

    @PostMapping(value = "/addApplication", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> addApplication (@RequestBody Application application){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(passwordManagerService.addApplication(application));
    }

    @GetMapping(value = "/lookupApp/{appName}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> lookupApplication (@PathVariable String appName){
        return ResponseEntity.status(HttpStatus.OK).body(passwordManagerService.lookupApplication(appName));
    }

    @GetMapping(value = "/searchApps/{username}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> searchApplications(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(passwordManagerService.getAllAplications(username));
    }


}
