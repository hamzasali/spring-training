package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

    @RequestMapping //no end point mean default
    public String home2() {
        return "home.html";
    }

    @RequestMapping({"/apple", "/orange"}) //more than one end point mean for same page
    public String home3() {
        return "home.html";
    }
}
