package com.repository;

import com.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className: EmployeeRepository
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {


}