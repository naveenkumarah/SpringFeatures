package com.sample.rest.controller;

import org.apache.cxf.common.util.Base64Utility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.sample.mvc.config.AppConfig;
import com.sample.mvc.pojo.User;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RestControllerTest {
	/*@Autowired
    private RestTemplate restTemplate;*/
	
	/*
	 * 	HTTP GET : getForObject, getForEntity
		HTTP PUT : put(String url, Object request, String urlVariables)
		HTTP DELETE : delete
		HTTP POST : postForLocation(String url, Object request, String urlVariables), postForObject(String url, Object request, Class responseType, String uriVariables)
		HTTP HEAD : headForHeaders(String url, String urlVariables)
		HTTP OPTIONS : optionsForAllow(String url, String urlVariables)
		HTTP PATCH and others : exchange execute
	 * 
	 */
	
	public  final String REST_SERVICE_URI = "http://localhost:8080/SpringMVC-1.0";
	
	 /*private static void setMethodHeaders(HttpMethod httpMethod, String name, String password) {
	        if (httpMethod instanceof PostMethod || httpMethod instanceof PutMethod) {
	            httpMethod.setRequestHeader("Content-Type", "application/xml");
	        }         
	        httpMethod.setDoAuthentication(false);
	        httpMethod.setRequestHeader("Accept", "application/xml");
	        httpMethod.setRequestHeader("Authorization", 
	                             "Basic " + base64Encode(name + ":" + password));
	          
	    }*/

	 private static String base64Encode(String value) {
	        return Base64Utility.encode(value.getBytes());
	   }
	 
	 String name="naveen";
	 String password="naveen";
		/*
	@Test
	public void testListAllUsers() {
		 RestTemplate restTemplate = new RestTemplate();
		
		
		 String result="";
	        try {
	            String httpResult = restTemplate..getForObject("http://localhost:8080/SpringMVC-1.0/user/",
	                                      String.class);
	            result = "Message SUCCESS result: " + httpResult;
	        } catch (HttpStatusCodeException e) {
	            result = "Get FAILED with HttpStatusCode: " + e.getStatusCode()
	                       + "|" + e.getStatusText();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        }
	        System.out.println(result);
	}


	
	// GET 
	@Test
	@SuppressWarnings("unchecked")
	public  void testListAllUsers1(){
        System.out.println("Testing listAllUsers API-----------");
        
      
         
        RestTemplate restTemplate = new RestTemplate();
       restTemplate.exchange(REST_SERVICE_URI+"/user/", HttpMethod.GET,null, List.class);
       List<LinkedHashMap<String, Object>> usersMap = null;
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }  */

	@Test
	public  void testGetUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
       // User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/7", User.class);
       // System.out.println(user);
        
         HttpHeaders headers = new HttpHeaders();
		 headers.add("Accept", "application/xml");
		 headers.add("Authorization","Basic " + base64Encode(name + ":" + password));
		 HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
		 	ResponseEntity<User> personEntity = restTemplate.exchange(REST_SERVICE_URI+"/user/1", HttpMethod.GET, entity, User.class);
		 	System.out.println(personEntity.getBody());

    }
		/*
   //  POST 
	@Test
	public  void testCreateUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(0,"Sanjoy",51,134);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }*/
    /*
     //PUT 
	@Test
	public  void testUpdateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User(1,"Shruthi Swamy",33, 70000);
        restTemplate.put(REST_SERVICE_URI+"/user/7", user);
        System.out.println(user);
    }
 
    // DELETE 
	@Test
	public  void testDeleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/1");
    }
 
 
   /* // DELETE 
	@Test
	public  void testDeleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
    }*/

}
