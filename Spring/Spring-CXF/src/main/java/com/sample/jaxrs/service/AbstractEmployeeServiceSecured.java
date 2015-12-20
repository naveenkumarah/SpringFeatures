package com.sample.jaxrs.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sample.dao.model.Employee;

@Path("/")
public abstract class AbstractEmployeeServiceSecured implements EmployeeServiceSecured {
     
    
 
    @GET
    @Path("/employee/")
    public abstract Response findAllEmployees();
    
    @GET
    @Path("/employee/{id}/")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public abstract Response findById(@PathParam("id") String id);
    
    @GET
    @Path("/employee/SSN-{ssn}/")
    public abstract Response findEmployeeBySsn(@PathParam("ssn") String ssn);

   /* @PUT
    @Path("/employee/{id}")
    public abstract Response updateCustomer(@PathParam("id") Long id, Employee customer);*/
    
    @POST
    @Path("/employee/")
    public abstract Response saveEmployee(Employee employee);

    @DELETE
    @Path("/employee/{ssn}/")
    public abstract Response deleteEmployeeBySsn(@PathParam("ssn") String ssn);



}
