package com.sample.jaxrs.service;

import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.cxf.common.util.Base64Utility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.mvc.config.AppConfig;

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceSecuredImplTest {
	
	@Test
	public void testGetCustomerInfo(String name, String password, int id) throws Exception {
        
        System.out.println("HTTP GET to query customer info, user : " 
            + name + ", password : " + password);
        GetMethod get = 
            new GetMethod("http://localhost:9002/customerservice/customers/" + id);
        setMethodHeaders(get, name, password);
        handleHttpMethod(get);
    } 

    public void testAddCustomerInfo(String name, String password) throws Exception {
               
        System.out.println("HTTP POST to add customer info, user : " 
            + name + ", password : " + password);
        PostMethod post = new PostMethod("http://localhost:9002/customerservice/customers");
        setMethodHeaders(post, name, password);
        RequestEntity entity = new InputStreamRequestEntity(
            this.getClass().getClassLoader().getResourceAsStream("add_customer.xml"));
        post.setRequestEntity(entity);
        
        handleHttpMethod(post);
    } 

    public void testUpdateCustomerInfo(String name, String password) throws Exception {
               
        System.out.println("HTTP PUT to update customer info, user : " 
            + name + ", password : " + password);
        PutMethod put = new PutMethod("http://localhost:9002/customerservice/customers/123");
        setMethodHeaders(put, name, password);
        RequestEntity entity = new InputStreamRequestEntity(
            this.getClass().getClassLoader().getResourceAsStream("update_customer.xml"));
        put.setRequestEntity(entity);
        
        handleHttpMethod(put);
    } 

    public void testDeleteCustomerInfo(String name, String password, int id) throws Exception {
               
        System.out.println("HTTP DELETE to update customer info, user : " 
            + name + ", password : " + password);
        System.out.println("Confirming a customer with id " + id + " exists first");
        testGetCustomerInfo(name, password, id);
        System.out.println("Deleting now...");
        DeleteMethod del = 
            new DeleteMethod("http://localhost:9002/customerservice/customers/" + id);
        setMethodHeaders(del, name, password);
        handleHttpMethod(del);
        System.out.println("Confirming a customer with id " + id + " does not exist anymore");
        testGetCustomerInfo(name, password, id);
    }  

    private  void handleHttpMethod(HttpMethod httpMethod) throws Exception {
        HttpClient client = new HttpClient();

        try {
            int statusCode = client.executeMethod(httpMethod);
            System.out.println("Response status : " + statusCode); 

            Response.Status status =  Response.Status.fromStatusCode(statusCode);

            if (status == Response.Status.OK) {
                System.out.println(httpMethod.getResponseBodyAsString());    
            } else if (status == Response.Status.FORBIDDEN) {
                System.out.println("Authorization failure");
            } else if (status == Response.Status.UNAUTHORIZED) {
                System.out.println("Authentication failure");
            }
            System.out.println(); 

        } finally {
            // release any connection resources used by the method
            httpMethod.releaseConnection();
        }  
    }

    private  void setMethodHeaders(HttpMethod httpMethod, String name, String password) {
        if (httpMethod instanceof PostMethod || httpMethod instanceof PutMethod) {
            httpMethod.setRequestHeader("Content-Type", "application/xml");
        }         
        httpMethod.setDoAuthentication(false);
        httpMethod.setRequestHeader("Accept", "application/xml");
        httpMethod.setRequestHeader("Authorization", 
                             "Basic " + base64Encode(name + ":" + password));
          
    }

    private  String base64Encode(String value) {
        return Base64Utility.encode(value.getBytes());
    }
}
