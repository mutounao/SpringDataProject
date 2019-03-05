package com.service;

import com.domain.Employee;
import com.repository.EmployeeCrudRepository;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @className: EmployeeService
 * @author: Dong Yu
 * @date: 2019/3/5 11:59
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    /**
     * 根据用户id 修改年龄
     *
     * @param id
     * @param age
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: void
     */
    @Transactional(rollbackOn = Exception.class)
    public void updateAge(Integer id, Integer age) {
        employeeRepository.updateAge(id, age);
    }


    /**
     * 根据id删除
     *
     * @param id
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: void
     */
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    /**
     * 保存测试数据
     *
     * @param employees
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: void
     */
    @Transactional(rollbackOn = Exception.class)
    public void sava(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }

    /**
     * 删除所有测试数据
     *
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: void
     */

    @Transactional(rollbackOn = Exception.class)
    public void deleteAll() {
        employeeCrudRepository.deleteAll();
    }


}