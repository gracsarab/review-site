package com.sample.secondtry;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class HomeController{
    @Autowired //creates new welcome service w/o "=new"
    private WelcomeService service;

    @RequestMapping("/")
    public String index(){
        return service.retrieveWelcomeMessage();
    }
    @RequestMapping(path = "/{username}/Goodbye")
    public String goodbye(@PathVariable("username") String username){
        return "Goodbye, " + username;
    }
}

