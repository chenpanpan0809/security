package com.panpan.security.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.panpan.security.entity.User;
import com.panpan.security.service.UserDbService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private   UserDbService userDbService;

  /*  @RequestMapping("")
    public String input(){
        return "register-input";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(User user){
        Boolean result  = false;
        String msg = "";
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPhone())){
            msg = "请完善先关信息！";
            return handelResult(result,msg);
        }
        try {
            QueryWrapper<User> queryWrapperPhone = new QueryWrapper<User>();
            queryWrapperPhone.eq("PHONE",user.getPhone());
            User one = userDbService.getOne(queryWrapperPhone);
            if (one != null){
                msg = "当前手机号已被注册";
                return  handelResult(false,msg);
            }

            QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
            queryWrapper.eq("USERNAME",user.getUsername());
            one = userDbService.getOne(queryWrapper);
            if (one != null){
                msg = "当前昵称已被注册";
                return  handelResult(false,msg);
            }
            User userTem = new User();
            userTem.setUsername(user.getUsername());
            userTem.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userTem.setPhone(user.getPhone());
            userTem.setEnable(true);
            userDbService.save(userTem);
            result = true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        return  handelResult(result,msg);
    }*/
}
