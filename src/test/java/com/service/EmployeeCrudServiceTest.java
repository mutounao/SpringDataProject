package com.service;

import com.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: EmployeeServiceTest
 * @author: Dong Yu
 * @date: 2019/3/5 12:02
 */
public class EmployeeCrudServiceTest {

    private EmployeeService employeeService = null;
    private AbstractApplicationContext context = null;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        employeeService = context.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testSave() {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = null;

        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test" + i);
            employee.setId(i);
            employee.setAge(100 - i);
            employees.add(employee);
        }
        employeeService.sava(employees);
    }

    @Test
    public void testDelete() {
        employeeService.deleteAll();
    }
}