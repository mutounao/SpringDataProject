package com.repository;

import com.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc:
 * @className: EmployeeJpaRepositoryTest
 * @author: Dong Yu
 * @date: 2019/3/5 16:14
 */
public class EmployeeJpaRepositoryTest {
    private EmployeeJpaRepository employeeJpaRepository = null;
    private AbstractApplicationContext context = null;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        employeeJpaRepository = context.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind() {
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println("Id:" + employee.getId() + ", Name: " + employee.getName() + ", age: " + employee.getAge());

    }

}