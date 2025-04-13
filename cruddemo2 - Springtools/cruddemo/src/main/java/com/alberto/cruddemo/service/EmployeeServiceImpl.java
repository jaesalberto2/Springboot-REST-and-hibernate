package com.alberto.cruddemo.service;
import com.alberto.cruddemo.dao.EmployeeRepository;
import  com.alberto.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {
    // need to inject employee dao
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;

    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int theId) {
        return employeeRepository.findById(theId).orElse(null);
    }
    @Override
    public Employee save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
        return theEmployee;
    }
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

}
