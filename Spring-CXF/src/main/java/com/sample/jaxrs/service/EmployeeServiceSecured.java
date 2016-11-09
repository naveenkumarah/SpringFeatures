
package com.sample.jaxrs.service;

import javax.ws.rs.core.Response;

import org.springframework.security.access.annotation.Secured;

import com.sample.dao.model.Employee;


public interface EmployeeServiceSecured {
    
   /* @Secured({"ROLE_ADMIN" })
    Customer getCustomer(String id);

    @Secured("ROLE_ADMIN")
    Response updateCustomer(Long id, Customer customer);
    
    @Secured("ROLE_ADMIN")
    Response addCustomer(Customer customer);

    @Secured("ROLE_ADMIN")
    Response deleteCustomer(String id);*/
    
    @Secured({"ROLE_ADMIN" })
    Response findById(String id);
    
    @Secured({"ROLE_ADMIN" })
    Response saveEmployee(Employee employee);
     
    @Secured({"ROLE_ADMIN" })
    Response deleteEmployeeBySsn(String ssn);
    
    @Secured({"ROLE_ADMIN" })
    Response findAllEmployees();
 
    @Secured({"ROLE_ADMIN" })
    Response findEmployeeBySsn(String ssn);

}
