package com.ithei.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithei.reggie.entity.Employee;
import com.ithei.reggie.mapper.EmployeeMapper;
import com.ithei.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl <EmployeeMapper, Employee>implements EmployeeService {
}
