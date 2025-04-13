package com.alberto.cruddemo.dao;

import com.alberto.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//that's it.. .. no need to write any code here
}
