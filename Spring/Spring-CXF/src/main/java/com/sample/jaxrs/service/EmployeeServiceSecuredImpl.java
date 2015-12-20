package com.sample.jaxrs.service;


import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.dao.EmployeeDao;
import com.sample.dao.model.Employee;

public class EmployeeServiceSecuredImpl extends AbstractEmployeeServiceSecured {

	@Autowired
	EmployeeDao employeeDao;
	
   

    /*public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);
        return c;
    }
    
    public Response updateCustomer(Long id, Customer customer) {
        System.out.println("----invoking updateCustomer, Customer name is: " + customer.getName());
        Customer c = customers.get(id);
        if (c == null || c.getId() != customer.getId()) {
            throw new WebApplicationException();
        }
        customers.put(customer.getId(), customer);
        return Response.ok(customer).build();
    }

    public Response addCustomer(Customer customer) {
        System.out.println("----invoking addCustomer, Customer name is: " + customer.getName());
        customer.setId(++currentId);

        customers.put(customer.getId(), customer);

        return Response.ok(customer).build();
    }
    
    
    public Response deleteCustomer(String id) {
        System.out.println("----invoking deleteCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.remove(idNumber);

        Response r;
        if (c != null) {
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }*/
	 @Transactional
    public Response saveEmployee(Employee employee) {
    	System.out.println("----invoking saveEmployee, Customer name is: " + employee.getName());
    	employeeDao.saveEmployee(employee);
    	
    	 return Response.ok(employee).build();
		
	}
    @Transactional
    public Response findById(String id) {
    long idNumber = Long.parseLong(id);
   	 System.out.println("----invoking findById, Employee id is: " + id);
   	Employee employee=employeeDao.findById(idNumber);
   	Response r;
    if (employee != null) {
        r = Response.ok(employee).build();
    } else {
        r = Response.status(Status.NOT_FOUND).build();
    }        
	return r;
	}
    @Transactional
    public Response deleteEmployeeBySsn(String ssn) {
    	 System.out.println("----invoking deleteEmployeeBySsn, ssn id is: " + ssn);
    	 employeeDao.deleteEmployeeBySsn(ssn);
    	return Response.ok().build();
	}

    @Transactional
	public Response findAllEmployees() {
		 System.out.println("----invoking findAllEmployees");
		List<Employee> employees=employeeDao.findAllEmployees();
		
		return Response.ok(employees).build();
	}
    @Transactional
	public Response findEmployeeBySsn(String ssn) {
		Employee employee=employeeDao.findEmployeeBySsn(ssn);
		Response r;
        if (employee != null) {
            r = Response.ok(employee).build();
        } else {
            r = Response.status(Status.NOT_FOUND).build();
        }        
		return r;
	}

}
