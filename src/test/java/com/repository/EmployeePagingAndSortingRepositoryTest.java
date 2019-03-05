package com.repository;

import com.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @className: EmployeePagingAndSortingRepositoryTest
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */

public class EmployeePagingAndSortingRepositoryTest {

    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;
    private AbstractApplicationContext context = null;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        employeePagingAndSortingRepository = context.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testPage() {

        //page:index是从0开始的 ，size 分页数量
        Pageable pageable = new PageRequest(0, 10);

        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询总页数" + page.getTotalPages());
        System.out.println("查询总记录数" + page.getTotalElements());
        System.out.println("查询当前第几页" + page.getNumber() + 1);
        System.out.println("查询当前页面的集合" + page.getContent());
        System.out.println("查询当前页面的记录数" + page.getNumberOfElements());

    }

    @Test
    public void testPageAndSort() {

        //        降序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        //page:index是从0开始的 ，size 分页数量
        Pageable pageable = new PageRequest(0, 10, sort);

        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询总页数" + page.getTotalPages());
        System.out.println("查询总记录数" + page.getTotalElements());
        System.out.println("查询当前第几页" + page.getNumber() + 1);
        System.out.println("查询当前页面的集合" + page.getContent());
        System.out.println("查询当前页面的记录数" + page.getNumberOfElements());

    }

    @Test
    public void testPageAndSort2() {

        //        升序
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(order);
        //page:index是从0开始的 ，size 分页数量
        Pageable pageable = new PageRequest(0, 10, sort);

        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询总页数" + page.getTotalPages());
        System.out.println("查询总记录数" + page.getTotalElements());
        System.out.println("查询当前第几页" + page.getNumber() + 1);
        System.out.println("查询当前页面的集合" + page.getContent());
        System.out.println("查询当前页面的记录数" + page.getNumberOfElements());

    }
}