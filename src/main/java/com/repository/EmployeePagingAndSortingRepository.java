package com.repository;

import com.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @className: EmployeePagingAndSortingRepository
 * @author: Dong Yu
 * @date: 2019/3/1 15:36
 */

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {


}