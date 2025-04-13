package com.alberto.cruddemo.dao;

import com.alberto.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    //define deo implementation

    Student findById(int id);


    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void deleteById(Integer id);

}
