package com.repository;

import com.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @className: EmployeeRepository
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */

public interface EmployeeJpaSpecificationRepository extends JpaRepository<Employee, Integer> , JpaSpecificationExecutor<Employee> {


}