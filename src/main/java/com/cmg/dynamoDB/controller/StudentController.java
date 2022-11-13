package com.cmg.dynamoDB.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmg.dynamoDB.entity.Student;
import com.cmg.dynamoDB.service.StudentService;
import com.cmg.dynamoDB.util.ResponseUtil;

@RestController
@RequestMapping("controller/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil addStudent(@RequestBody Student student){
		return new ResponseUtil(200,"Student Added Successfully",studentService.addStudent(student));
	}
	
	@GetMapping(path="allCustomers",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getAllStudent(){
		return new ResponseUtil(200,"Done",studentService.getAllStudent());
	}
	
	
	@GetMapping(path="singleCustomer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getStudent(@PathVariable String id){
		return new ResponseUtil(200,"Done",studentService.getStudentById(id));
	}
	
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil UpdateStudent(@RequestBody Student student ){
		return new ResponseUtil(200,"Customer Updated Successfully",studentService.updateStudent(student));
	}
	
	@DeleteMapping(path="/remove/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil DeleteStudent(@PathVariable String id){
		return new ResponseUtil(200,"Customer Deleted Successfully",studentService.deleteStudent(id));
	}
}
