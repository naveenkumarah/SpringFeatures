package com.sample.ws.service;

import javax.jws.WebService;

import com.sample.ws.pojo.Student;

@WebService(endpointInterface = "com.sample.ws.service.IStudentService")
public class StudentServiceImpl implements IStudentService {
	
	public Student getStudent(Student student) {	
		
        System.out.println("student:"+student.getId());
        student.setName("Naveen Kumar A.H");
        student.setCourse("B.E");
        return student;
    }
}
