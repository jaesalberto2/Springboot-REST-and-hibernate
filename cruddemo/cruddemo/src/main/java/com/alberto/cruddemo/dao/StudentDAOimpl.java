package com.alberto.cruddemo.dao;

import com.alberto.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;
    // inject entity manager using constructor injection


    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        //save the student
        entityManager.persist(student);
        //print out the saved student
        System.out.println("Saved student: " + student);

    }

    @Override
    public Student findById(int id) {


        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
        //return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //set parameter
        theQuery.setParameter("theData", theLastName);
        //execute query and get result list
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        //update the student
        entityManager.merge(theStudent);
        //print out the updated student
        System.out.println("Updated student: " + theStudent);

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        //retrieve the student with the primary key
        Student theStudent = entityManager.find(Student.class, id);
        //delete the student with the primary key
        entityManager.remove(theStudent);
    }
}










