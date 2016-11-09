package com.sample.jdk8;

import java.util.Arrays;

public class LambdaExpressionSort {
	public static void main(String[] ar) {
		Animal[] animalArr = { new Animal("Lion"), new Animal("Crocodile"), new Animal("Tiger"),
				new Animal("Elephant") };

		System.out.println("Before Sort: " + Arrays.toString(animalArr));
		Arrays.sort(animalArr, Animal::animalCompare);
		System.out.println("After Sort: " + Arrays.toString(animalArr));
	}
}

class Animal {
	String name;

	Animal(String name) {
		this.name = name;
	}

	public static int animalCompare(Animal a1, Animal a2) {
		return a1.name.compareTo(a2.name);
	}

	public String toString() {
		return name;
	}
}
