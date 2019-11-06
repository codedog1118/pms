package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.bean.EmployeeExample;
import com.ujiuye.sys.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> getManagers() {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andPFkEqualTo(4);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        return employees;
    }

    public Employee login(Employee employee) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        criteria.andPasswordEqualTo(employee.getPassword());
        List<Employee> employees = employeeMapper.selectByExample(example);
        if(employees != null && employees.size()>0){
            employee=employees.get(0);
            return employee;
        }
        return null;
    }

    public List<Employee> getOthers(Integer eid) {
        return employeeMapper.getOthers(eid);
    }
}
