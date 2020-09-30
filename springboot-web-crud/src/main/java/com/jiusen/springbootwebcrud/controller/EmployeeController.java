package com.jiusen.springbootwebcrud.controller;

import com.jiusen.springbootwebcrud.dao.EmployeeDao;
import com.jiusen.springbootwebcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工，返回列表页面
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps", employees);
        //thymeleaf默认就会拼接
        //classpath:/template/xxxx.html
        return "emp/list";
    }
}
