package com.bonappetit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String notLoggedHome() {
        return "index";
    }

    @GetMapping("/home")
    public String loggedHome() {
        return "home";
    }
}
