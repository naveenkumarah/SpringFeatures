package com.sample.ws.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.ws.pojo.Student;

@ContextConfiguration(locations = {"classpath:application-client.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SOAPClientTest {
	
	@Autowired
	private IStudentService studentService;
	
	@Test
	public void testCallSoapWebService() {
		Student student=new Student();
		student.setId(416436l);
		
		Student studentRes = studentService.getStudent(student);
	   System.out.println("Response:  Name:" + studentRes.getName() +" Course:"+studentRes.getCourse());
	}
}
