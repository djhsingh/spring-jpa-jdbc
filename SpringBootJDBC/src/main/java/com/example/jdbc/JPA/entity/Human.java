package com.example.jdbc.JPA.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="human")
@NamedQuery(name = "find_all", query = "select h from Human h" )
public class Human {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	@NotNull
	private int id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "location")
	private String location ;
	
	@Column(name = "birth_date")
	private Date birth_date ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public Human(int id, String name, String location, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}
	@Override
	public String toString() {
		return "Human [id=" + id + ", name=" + name + ", location=" + location + ", birth_date=" + birth_date + "]";
	}
	public Human() {
		super();
	}
	
}
