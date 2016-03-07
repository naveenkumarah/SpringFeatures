package com.sample.jdk8;

public class LambdaVariableAccess {
	public String wildAnimal = "Lion";

	public static void main(String[] arg) {
		new LambdaVariableAccess().lambdaExpression();
	}

	public void lambdaExpression(){
        String domesticAnimal = "Dog";
        
        new Thread (() -> {
            System.out.println("Class Level: " + this.wildAnimal);
        	System.out.println("Method Level: " + domesticAnimal);
       }).start();        
    }
}
