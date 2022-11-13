package com.cmg.dynamoDB.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmg.dynamoDB.entity.Student;
import com.cmg.dynamoDB.repo.StudentRepo;


@Service
@Transactional
public class StudentService {
 

	@Autowired
	StudentRepo studentRepo;
	
	public Student addStudent(Student student) {
		return  studentRepo.save(student);	
	}
	public Iterable<Student> getAllStudent(){
		return studentRepo.findAll();
	}
	public Optional <Student> getStudentById(String id){
		return studentRepo.findById(id);
	}
	
	public Student updateStudent(Student student) {
		boolean isExist=studentRepo.existsById(student.getId());
		if (!isExist) {
			throw new RuntimeException("Student Not Found");
		}else {
			return studentRepo.save(student);
		}
	}
	public String deleteStudent(String id) {
		boolean isExist=studentRepo.existsById(id);
		if (!isExist) {
			throw new RuntimeException("Student Not Found");
		}else {
			studentRepo.deleteById(id);
			return "Deleted";
		}
	}
	
}
