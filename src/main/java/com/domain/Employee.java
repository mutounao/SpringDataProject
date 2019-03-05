package com.domain;

import javax.persistence.*;

/**
 * 雇员：先开发实体类=====》自动生成数据表
 *
 * @className: Employee
 * @author: Dong Yu
 * @date: 2019/3/1 14:49
 */

@Entity
@Table(name = "test_employee")
public class Employee {


    private Integer id;
    private String name;
    private Integer age;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 3)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}