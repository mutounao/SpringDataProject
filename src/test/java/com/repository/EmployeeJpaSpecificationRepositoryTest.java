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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * @desc:
 * @className: EmployeeJpaSpecificationRepositoryTest
 * @author: Dong Yu
 * @date: 2019/3/5 16:35
 */
public class EmployeeJpaSpecificationRepositoryTest {

    private EmployeeJpaSpecificationRepository employeeJpaSpecificationRepository = null;
    private AbstractApplicationContext context = null;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        employeeJpaSpecificationRepository = context.getBean(EmployeeJpaSpecificationRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        context = null;
        System.out.println("tearDown");
    }

    /**
     * 1)分页
     * 2)排序
     * 3)查询条件
     */
    @Test
    public void testQuery() {
        //        降序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        //page:index是从0开始的 ，size 分页数量
        Pageable pageable = new PageRequest(0, 10, sort);

        /**
         * root: 就是我们要查询的类型（employee）
         * query: 添加查询的条件
         * cb: 构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root
                    , CriteriaQuery<?> query
                    , CriteriaBuilder cb) {

                Path path = root.get("age");
                Predicate predicate = cb.gt(path, 50);

                Path path1 = root.get("name");
                Predicate predicate2 = cb.like(path1.as(String.class), "%" + "9" + "%");

                query.where(cb.and(predicate2,predicate));

                return query.getRestriction();
            }
        };

        Page<Employee> page = employeeJpaSpecificationRepository.findAll(specification, pageable);

        System.out.println("查询总页数" + page.getTotalPages());
        System.out.println("查询总记录数" + page.getTotalElements());
        System.out.println("查询当前第几页" + page.getNumber() + 1);
        System.out.println("查询当前页面的集合" + page.getContent());
        System.out.println("查询当前页面的记录数" + page.getNumberOfElements());
    }
}