package com.sample.ws.service;

import javax.jws.WebService;

import com.sample.ws.pojo.Student;

@WebService
public interface IStudentService {
	Student getStudent(Student student);
	
}
