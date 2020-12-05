package com.panpan.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController extends BaseController{

    @RequestMapping("")
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("loginMsg",authentication.toString());
        return "index";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/testAuthorityOne")
    @ResponseBody
    public String testAuthorityOne(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("loginMsg",authentication.toString());
        return "testAuthorityOne";
    }


    @PreAuthorize(value = "hasAnyRole('DEMO')")
    @RequestMapping("/testAuthority")
    @ResponseBody
    public String testAuthority(){
        return "testAuthority!";
    }
}
