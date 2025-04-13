package com.alberto.cruddemo;

import com.alberto.cruddemo.dao.StudentDAO;
import com.alberto.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// This is where you can add any startup logic if needed

	/*createStudents(studentDAO);*/
			createMultipleStudents(studentDAO);

/*
			readStudent(studentDAO);
*/
/*
			queryForStudents(studentDAO);
*/
/*
			queryForStudentsByLastName(studentDAO);
*/
	/*		updateStudent(studentDAO);*/

/*
			deleteStudent(studentDAO);
*/


		};
		}

	private void deleteStudent(StudentDAO studentDAO) {
		//delete student with id of 1
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.deleteById(studentId);
		System.out.println("Deleted student with id: " + studentId);

		System.out.println("Done!");
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Updating student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");
		//update the student
		studentDAO.update(myStudent);
		//display the updated student
		System.out.println("Updated student: " + myStudent);
		System.out.println("Done!");
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
	//get a list of students
		System.out.println("Getting all students with last name of 'Doe'...");
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		System.out.println("Getting all students...");
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent); //save the student
		//display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());


		//retrieve the student based on the id: primary key

		System.out.println("Retrieving student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		//display the student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");

		Student tempStudent2 = new Student("Lisa","Ann","lisa@luv2code.com");

		Student tempStudent3 = new Student("Alberto","Escareno","alberto@luv2code.com");

		//save the students
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1); //save the student
		studentDAO.save(tempStudent2); //save the student
		studentDAO.save(tempStudent3); //save the student
		//display the id of the saved students
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());

	}

	private void createStudents(StudentDAO studentDAO) {
	//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent); //save the student
		//display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}



	}


