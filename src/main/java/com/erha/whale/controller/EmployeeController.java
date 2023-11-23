package com.erha.whale.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.erha.whale.common.R;
import com.erha.whale.entity.Employee;
import com.erha.whale.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@Slf4j  //输出日志方便调试
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    //把创建的接口注入进来
    @Autowired
    private EmployeeService employeeService;


    /**
     * 员工登录
     *
     * @param request
     * @param employee
     * @return 处理逻辑：
     * 1. 密码md5加密
     * 2. 根据用户名查询数据库
     * 3. 比对密码
     * 4. 查看状态
     * 5. 将员工的id存放到session
     */
    @PostMapping("/login")
    //将员工对象的id存储到session，以方便获取登录对象
    public R<Object> login(HttpServletRequest request, @RequestBody Employee employee){
        //1.密码加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2.根据用户输入名字，查数据库信息,根据页面提交的用户名username查询数据库,包装一个查询对象，
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        //2.1 如果没有查询到就返回错误
        if(emp == null){
            return R.error("登录失败！");
        }

        //3.比对密码
        if(!emp.getPassword().equals(password)){
            return R.error("登录失败！");
        }

        //4.查看员工状态
        if(emp.getStatus()==0){
            return R.error("账号已禁用！");
        }

        //5.将用户id存放在session
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * 退出登录功能
     * @param request
     *
     * 需求分析：点击退出按钮像/employee/logout发送退出请求，请求方式为post
     * 代码开发：
     *  1. 创建controller，清理session中的用户信息
     *  2. 返回结果，页面跳转到登录姐界面
     * 功能测试
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理session中的用户信息
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }


}





























