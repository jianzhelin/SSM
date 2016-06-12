package com.example.controller;

import com.example.mybatis.pojo.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/11.
 */
@Controller
public class LoginController {
    @Autowired
    UsersService usersService;
    @RequestMapping("/")
    public String base(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(Users users, Map<String,Object> model){
        if(usersService.login(users)>0) {
            System.out.println("用户存在");
            model.put("time", new Date());
            model.put("message", "hello world");
        }else{
            System.out.println("用户不存在");
            model.put("time", new Date());
            model.put("message", "farewell world");
        }
        return "index";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request){
        //获取session
        HttpSession session=request.getSession();
        //获取全局
        ServletContext application=RequestContextUtils.findWebApplicationContext(request).getServletContext();
        return "fuck u";
    }
}
