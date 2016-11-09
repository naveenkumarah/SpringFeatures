package com.sample.ws.service.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	 private static final QName SERVICE_NAME = new QName("http://service.ws.sample.com/", "StudentServiceImplService");
	 private static final QName PORT_NAME = new QName("http://service.ws.sample.com/", "StudentServiceImplPort");
	 private static String endpointAddress = "http://localhost:8080/SpringMVC-1.0/services/StudentService";
	 
 	private static void wsdl2JavaClient(Student student){
 		Service service = new StudentServiceImplService();//Service.create(SERVICE_NAME);
		 
		 
		 // JAX-WS Proxy client
		 //Service service = Service.create(wsdlURL, SERVICE_NAME);
		 //IStudentService client = service.getPort(IStudentService.class);
		 
		// 

	        // Add a port to the Service
	       // service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
	        
	        IStudentService hw = service.getPort(IStudentService.class);
	        Student studentRes=hw.getStudent(student);
	        
	        System.out.println("Response:  Name:" + studentRes.getName() +" Course:"+studentRes.getCourse());
 	}
 	private static void jaxWSProxyClient(Student student) throws MalformedURLException{
 		URL wsdlURL=new URL(endpointAddress+"?wsdl");
 		Service service = Service.create(wsdlURL, SERVICE_NAME);
 		IStudentService hw = service.getPort(IStudentService.class);
        Student studentRes=hw.getStudent(student);
        
        System.out.println("Response:  Name:" + studentRes.getName() +" Course:"+studentRes.getCourse());
 	}
 
	 public static void main(String[] args) {
		 
		 Student student=new Student();
		 student.setId(416436l);
		
		 try {
			 wsdl2JavaClient(student);
			//jaxWSProxyClient(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	 
}
