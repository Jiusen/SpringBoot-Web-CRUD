package com.jiusen.springbootwebcrud.controller;

import com.jiusen.springbootwebcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController
{
//    @RequestMapping({"/","/index.html"})
//    public String index()
//    {
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user)
    {
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map map)
    {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}