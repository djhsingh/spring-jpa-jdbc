package com.example.jdbc;

import static org.junit.jupiter.api.Assertions.*;


import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.jdbc.JPA.controller.HumanRestController;
import com.example.jdbc.JPA.entity.Human;
import com.example.jdbc.controller.PersonJdbcController;
import com.example.jdbc.daoForJdbc.PersonJdbcDao;
import com.example.jdbc.models.Person;

class JpaTest {


	@BeforeEach
	public void before()
	{
		System.out.println("Before testing----");
	}
	
	@Test
	void test() {
		
		PersonJdbcDao rest = new PersonJdbcDao();
		int idDeleted= rest.deleteById(1);
		System.out.println(idDeleted);
		assertEquals(idDeleted,1);
	}
 
	@AfterEach
	public void after()
	{
		System.out.println("After testing----");
	}
}
