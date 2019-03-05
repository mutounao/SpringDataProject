package com.repository;

import com.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @className: EmployeeRepository
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)

public interface EmployeeRepository extends Repository<Employee, Integer> {

    /**
     * 查询姓名
     *
     * @param name
     * @Author: Dong Yu
     * @date: 2019/3/1
     * @return: com.domain.Employee
     */
    Employee findByName(String name);


    /**
     * 模糊查询 根据姓名结束 和 年龄小于
     * where name like ?% and age < ?
     *
     * @param name
     * @param id
     * @Author: Dong Yu
     * @date: 2019/3/1
     * @return: java.util.List<com.domain.Employee>
     */
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer id);

    /**
     * 模糊查询 根据姓名开头和 年龄小于
     * where name like %? and age < ?
     *
     * @param name
     * @param id
     * @Author: Dong Yu
     * @date: 2019/3/1
     * @return: java.util.List<com.domain.Employee>
     */
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer id);

    /**
     * where name in (?,?,?) or age < ?
     *
     * @param id
     * @param names
     * @Author: Dong Yu
     * @date: 2019/3/1
     * @return: java.util.List<com.domain.Employee>
     */
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer id);

    /**
     * where name in(?,?,?) and age < ?
     *
     * @param id
     * @param names
     * @Author: Dong Yu
     * @date: 2019/3/2
     * @return: java.util.List<com.domain.Employee>
     */

    List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer id);

    /**
     * 查询 id 最大的
     *
     * @Author: Dong Yu
     * @date: 2019/3/4
     * @return: com.domain.Employee
     */
    @Query("select o from Employee o where id = (select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    /**
     * 查询根据name id
     *
     * @param name
     * @param age
     * @Author: Dong Yu
     * @date: 2019/3/4
     * @return: com.domain.Employee
     */
    @Query("select o from Employee o where o.name = ?1 and o.age = ?2")
    Employee queryParams1(String name, Integer age);

    /**
     * 查询根据name id
     *
     * @param name
     * @param age
     * @Author: Dong Yu
     * @date: 2019/3/4
     * @return: com.domain.Employee
     */
    @Query("select o from Employee o where o.name = :name and o.age = :age")
    Employee queryParams2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 模糊查询
     *
     * @param name
     * @Author: Dong Yu
     * @date: 2019/3/2
     * @return: java.util.List<com.domain.Employee>
     */

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    /**
     * 模糊 根据用户名查询
     *
     * @param name
     * @Author: Dong Yu
     * @date: 2019/3/2
     * @return: java.util.List<com.domain.Employee>
     */

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    /**
     * 总条数(一)
     *
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: long
     */
    @Query("select count(o) from Employee o")
    long getCount();

    /**
     * 总条数(二)
     *
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: long
     */
    @Query(nativeQuery = true, value = "select count(1) from Employee ")
    long queryCount();

    /**
     * 根据id修改age(年龄)
     *
     * @param id
     * @param age
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: void
     */

    @Modifying
    @Query("update Employee o set o.age = :age  where o.id = :id")
    void updateAge(@Param("id") Integer id, @Param("age") Integer age);

    /**
     * 根据id删除
     *
     * @param id
     * @Author: Dong Yu
     * @date: 2019/3/5
     * @return: void
     */

    void deleteById(Integer id);


}