package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			creaMultipleStudents(studentDAO);
//			readStudent(studentDAO);
// 		    queryForStudents(studentDAO);
//			queryForStudentsBylastName(studentDAO);
//			updateStudent(studentDAO);
//		    deleteStudent(studentDAO);
//		    deleteAllStudents(studentDAO);


		};
}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All students ");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Dleting student id :"+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id :primary Key
		int studentId=1;
		System.out.println("Getting student id :"+studentId);
		Student myStudent=studentDAO.findByID(studentId);
		// change first name to "scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Mahmoud");
		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("update student : "+myStudent.toString());

	}

	private void queryForStudentsBylastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findByLastName("omar");
		//display list of students
		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students= studentDAO.findAll();
		//display list of students
		for (Student student:students){
			System.out.println(student);

		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student Object
		System.out.println("Create new student Object ...");
		Student tempStudent=new Student("makram","Ali","makram@gmail.com");
		// save the student
		System.out.println("saving the student ..............");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("saved student . Generated id:"+theId);

		//retrieve student based on the id :primary Key
		System.out.println("Retrieving student with id :"+theId);
		Student myStudent=studentDAO.findByID(theId);
		System.out.println("Found the student"+myStudent);


		//display student

		System.out.println(studentDAO.findByID(1).toString());
	}

	private void creaMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 Student objects ...");
		Student tempStudent1=new Student("Mahmoud","Abdelaal","mahmoud.abdelaal.dev@gmail.com");
		Student tempStudent2=new Student("Ahmed","Mohammed","ahmed.mohammed.dev@gmail.com");
		Student tempStudent3=new Student("Mostafa","Omar","mostafa.omar.dev@gmail.com");

		//save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Create new Student object ...");
		Student tempStudent=new Student("Mahmoud","Abdelaal","mahmoud.abdelaal.dev@gmail.com");


		//save the student object
		System.out.println("Saving the Student ...");
		studentDAO.save(tempStudent);

		//display id of the save student
		System.out.println("Saved Student . Generated id :"+tempStudent.getId());


	}
}
