package com.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className: EmployeeServiceTest
 * @author: Dong Yu
 * @date: 2019/3/5 12:02
 */
public class EmployeeServiceTest {

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
    public void testUpdateAge() {
        employeeService.updateAge(1, 22);
    }

    @Test
    public void testDeleteById() {
        employeeService.deleteById(8);
    }
}