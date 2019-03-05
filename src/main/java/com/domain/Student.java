package com.domain;


import java.io.Serializable;

/**
 * @Description: 学生实体类
 * @Author: Dong Yu
 * @date: 2019/2/28
 */

public class Student implements Serializable {

    private static final long serialVersionUID = 2643085596501547039L;
    private long stuId;
    private String stuName;
    private String gender;
    private long age;
    private String address;


    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
