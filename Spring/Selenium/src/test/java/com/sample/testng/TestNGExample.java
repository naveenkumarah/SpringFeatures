package com.sample.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGExample {

  @Test(enabled=false)
  public void test1() {
    System.out.println("Hi New");
  }
  @Test(enabled=false)
  public void test2() {
    System.out.println("Hi New");
  }
  @Test(enabled=false)
  public void test3() {
    System.out.println("Hi New");
  }
  @Test(dataProvider="loginData")
  public void test4(String userName, String password) {
	  
	  
    System.out.println("userName:"+userName+"  password:"+password);
  }
  @DataProvider
	public Object[][] loginData() throws Exception {
	  Object[][] arrayObject= ExcelUtils.getTableArray("/apps/data.xlsx","Sheet1");
	  return arrayObject;
	}
}
