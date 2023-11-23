package com.erha.whale.mapper;

import com.erha.whale.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author serendipity
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2023-11-23 11:54:12
* @Entity com.erha.whale.entity.Employee
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}




