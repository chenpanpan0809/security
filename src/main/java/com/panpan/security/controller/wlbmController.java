package com.panpan.security.controller;

import com.panpan.security.service.WlbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wlbm")
public class wlbmController extends BaseController{

    @Autowired
    private WlbmService wlbmService;


    @RequestMapping("/list")
    public String list(Model model){
        return "wlbm/wlbm-list";
    }

    @RequestMapping("/listApi")
    @ResponseBody
    public Object listApi(Integer limit,Integer page,String param){
        return wlbmService.getPage(limit,page,param);
    }

}
