package com.repository;

import com.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @className: EmployeeCrudRepository
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}