package com.alberto.cruddemo.dao;

import com.alberto.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    // define fields for entity manager
    private EntityManager entityManager;

    // define constructor injection for entity manager
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return the employee
        return theEmployee;

    }

    @Override
    @Transactional

    public Employee save(Employee theEmployee) {
        // save or update the employee
        // if the id is 0, then this is a new employee

        Employee dbEmployee = entityManager.merge(theEmployee);

        // Return the employee with the generated id

        // if the employee is new, the id will be 0



        return dbEmployee;


    }

    @Override
    public void deleteById(int theId) {
        //find the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //remove the employee
        entityManager.remove(theEmployee);


    }
}
