package com.jiusen.springbootwebcrud.controller;

import com.jiusen.springbootwebcrud.dao.DepartmentDao;
import com.jiusen.springbootwebcrud.dao.EmployeeDao;
import com.jiusen.springbootwebcrud.entities.Department;
import com.jiusen.springbootwebcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps", employees);
        //thymeleaf默认就会拼接
        //classpath:/template/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求了请求参数的名字和Javabean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面

        System.out.println("保存的员工信息: " + employee);

        //保存员工
        employeeDao.save(employee);
        //redirect: 表示重定向到一个地址  /代表当前项目路径
        //forward: 表示转发到一个地址
        return "redirect:emps";
    }

    //员工修改, 来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        //查出部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        model.addAttribute("emp", employee);

        //回到修改页面(add是一个修改添加二合一的页面)
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改员工的数据: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        System.out.println("删除的员工编号: " + id);
        return "redirect:/emps";
    }
}
