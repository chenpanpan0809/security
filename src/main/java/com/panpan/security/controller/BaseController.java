package com.panpan.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {



    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        request.setAttribute("loginName",name);
        request.setAttribute("base",request.getContextPath());
    }

    public Object handelResult(Boolean result ,String msg){
        Map data = new HashMap<>();
        data.put("result",result);
        data.put("msg",msg);
        return data;
    }
}
