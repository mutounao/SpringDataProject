package com.dao;

import com.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @desc:
 * @className: StudentDaoImplTest
 * @author: Dong Yu
 * @date: 2019/2/28 20:14
 */
public class StudentDaoImplTest {
    @Test
    public void testQueryStudent() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.queryStudent();

        for (Student student : students) {
            System.out.println(student.getStuId() + "     " +
                    student.getStuName() + "     " +
                    student.getAge() + "     " +
                    student.getGender()
            );
        }
    }

    @Test
    public void testInsertStudent() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
//        student.setStuId(1);
        student.setStuName("1111");
        student.setAddress("111");
        student.setAge(11);
        student.setGender("1");

        studentDao.insertStudent(student);
    }
}