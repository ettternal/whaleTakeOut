package com.erha.whale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erha.whale.entity.Employee;
import com.erha.whale.service.EmployeeService;
import com.erha.whale.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author serendipity
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2023-11-23 11:54:12
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




