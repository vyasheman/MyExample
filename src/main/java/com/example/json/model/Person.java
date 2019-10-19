package com.example.json.model;

public class Person {
	private String name;
	private Person person;
	
	public String getName() {
		return name;
	}

	public Person setName(String name) {
		this.name = name;
		return this.person;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}
