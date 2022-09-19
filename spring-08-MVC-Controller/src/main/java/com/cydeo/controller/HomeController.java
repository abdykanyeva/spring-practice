package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/home")
    public String home(){  // which end point? www.amazon.com/login
        return "home.html";
    }

    @RequestMapping
    public String getHomePage2(){  // default will return
        return "home.html";
    }

    @RequestMapping("/ozzy")
    public String getHomePage3(){
        return "home.html";
    }

    @RequestMapping({"/apple", "/orange"})
    public String getHomePage4(){  // which end point? www.amazon.com/login
        return "home.html";
    }




}
