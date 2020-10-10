package com.jiusen.springbootwebcrud.controller;

import com.jiusen.springbootwebcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    1、浏览器、客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }

        @ExceptionHandler(UserNotExistException.class)
        public String handleException(Exception e, HttpServletRequest request){
            Map<String, Object> map = new HashMap<>();
            //传入我们自己的错误状态码 4XX 5XX,否则就不会进入定制错误页面的解析流程
            /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
            request.setAttribute("javax.servlet.error.status_code", 500);
            map.put("code", "user.notexist");
            map.put("message", e.getMessage());

            request.setAttribute("ext", map);
            return "forward:/error";
        }
}
