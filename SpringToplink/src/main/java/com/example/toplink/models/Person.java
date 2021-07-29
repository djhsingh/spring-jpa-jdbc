package com.example.toplink.models;

public class Person {
	
  private Long id;
  private String name;
  private Long age;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getAge() {
	return age;
}
public void setAge(Long age) {
	this.age = age;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
}
public Person(Long id, String name, Long age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
public Person() {
	super();
}
  
}
