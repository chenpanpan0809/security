package com.panpan.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

    @RequestMapping("")
    public String home(Model model){
        return "home";
    }
}
