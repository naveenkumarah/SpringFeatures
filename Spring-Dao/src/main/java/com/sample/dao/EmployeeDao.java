package com.sample.dao;

import java.util.List;

import com.sample.dao.model.Employee;

public interface EmployeeDao {
	 
    Employee findById(Long id);
 
    void saveEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
     
    List<Employee> findAllEmployees();
 
    Employee findEmployeeBySsn(String ssn);
 
}
