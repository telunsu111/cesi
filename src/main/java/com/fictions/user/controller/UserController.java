package com.fictions.user.controller;

import com.fictions.user.model.UserModel;
import com.fictions.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show/{id}")
    @ResponseBody
    public UserModel show(@PathVariable(value = "id")Integer id){
        UserModel user = userService.getUserByid(id);
        if(null != user)
            return user;
        else return null;
    }
}
