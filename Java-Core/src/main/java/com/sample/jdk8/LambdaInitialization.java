package com.sample.jdk8;

import java.util.concurrent.Callable;

public class LambdaInitialization {
	public static void main(String args[]) throws Exception{
		Callable[] animals = new Callable[]{()->"Lion", ()->"Crocodile"};
		
		System.out.println(animals[0].call());
	}
}
