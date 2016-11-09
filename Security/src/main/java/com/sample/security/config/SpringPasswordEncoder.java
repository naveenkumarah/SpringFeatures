package com.sample.security.config;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class SpringPasswordEncoder  
{  
  public static void main(String[] args) {  
    Md5PasswordEncoder md5 = new Md5PasswordEncoder();  
    String strEncodedPassword = md5.encodePassword("kumar",null);  
    System.out.println(strEncodedPassword);  
  }  
}   
