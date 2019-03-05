package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className: DataSourceTest
 * @author: Dong Yu
 * @date: 2019/3/1 00:33
 */
public class DataSourceTest {
    private AbstractApplicationContext context = null;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        context = null;
        System.out.println("tearDown");
    }

//    @Test
//    public void testDataSource() {
//        System.out.println("testDataSource");
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        Assert.notNull(dataSource);
//    }
    @Test
    public void testEntityManagerFactory(){

    }

}