package com.dao;

import com.domain.Student;

import java.util.List;

/**
 * 学生接口
 *
 * @Author: Dong Yu
 * @date: 2019/2/28
 */

public interface StudentDao {


    /**
     * 查询所有学生
     *
     * @Param: []
     * @return: java.util.List<com.domain.Student>
     * @Author: Dong Yu
     * @date: 2019/2/28
     */
    List<Student> queryStudent();


    /**
     * 添加学生
     *
     * @param student
     * @Author: Dong Yu
     * @date: 2019/2/28
     * @return: void
     */
    void insertStudent(Student student);

}