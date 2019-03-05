package com.dao;

import com.domain.Student;
import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @className: StudentDaoImpl
 * @author: Dong Yu
 * @date: 2019/2/28 19:57
 */

public class StudentDaoImpl implements StudentDao {
    /**
     * 查询所有学生
     *
     * @Param: []
     * @return: java.util.List<com.domain.Student>
     * @Author: Dong Yu
     * @date: 2019/2/28
     */
    @Override
    public List<Student> queryStudent() {


        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select stuId,stuName,gender,age,address from student";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int stuId = resultSet.getInt("stuId");
                String stuName = resultSet.getString("stuName");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");

                student = new Student();
                student.setStuId(stuId);
                student.setStuName(stuName);
                student.setGender(gender);
                student.setAge(age);
                student.setAddress(address);

                studentList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
        return studentList;
    }

    /**
     * 添加学生
     *
     * @param student
     * @Author: Dong Yu
     * @date: 2019/2/28
     * @return: void
     */
    @Override
    public void insertStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "insert into student(stuId,stuName,gender,age,address) value (?,?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, student.getStuId());
            preparedStatement.setString(2, student.getStuName());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setLong(4, student.getAge());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
    }

}