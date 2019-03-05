package com.repository;

import com.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 *
 * @className: EmployeeRepository
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */
public class EmployeeRepositoryTest {
    EmployeeRepository employeeRepository = null;
    private AbstractApplicationContext context = null;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        employeeRepository = context.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("张三");
        System.out.println("Id:" + employee.getId() + " Name: " + employee.getName() + " age: " + employee.getAge());
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("t", 22);

        for (Employee employee : employees) {
            System.out.println("Id:" + employee.getId() + ", Name: " + employee.getName() + ", age: " + employee.getAge());

        }
    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23);

        for (Employee employee : employees) {
            System.out.println("Id:" + employee.getId() + ", Name: " + employee.getName() + ", age: " + employee.getAge());

        }
    }

    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println("Id:" + employee.getId() + ", Name: " + employee.getName() + ", age: " + employee.getAge());

        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println("Id:" + employee.getId() + ", Name: " + employee.getName() + ", age: " + employee.getAge());

        }
    }


    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee.getId() + "," + employee.getName() + "," + employee.getAge());
    }

    @Test
    public void testGetEmployeeByNameAndAge() {
        Employee employee = employeeRepository.queryParams1("test16", 22);
        System.out.println(employee.getId() + "," + employee.getName() + "," + employee.getAge());
    }

    @Test
    public void testQueryParams1() {
        Employee employee = employeeRepository.queryParams2("test1", 20);
        System.out.println(employee.getId() + "," + employee.getName() + "," + employee.getAge());
    }

    @Test
    public void testQueryLike1() {

        List<Employee> employees = employeeRepository.queryLike1("test");

        for (Employee employee : employees) {
            System.out.println("Id:" + employee.getId() + ", Name: " + employee.getName() + ", age: " + employee.getAge());

        }
    }

    @Test
    public void testGetCount() {
        long count = employeeRepository.getCount();
        System.out.println("总条数：" + count);
    }

    @Test
    public void testQueryCount() {
        long count = employeeRepository.queryCount();
        System.out.println("总条数：" + count);
    }


}