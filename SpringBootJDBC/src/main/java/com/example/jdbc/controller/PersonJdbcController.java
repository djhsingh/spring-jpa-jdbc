package com.example.jdbc.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.daoForJdbc.PersonJdbcDao;
import com.example.jdbc.models.Person;

@RestController
@RequestMapping("/jdbc")
public class PersonJdbcController {

	private Logger _logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJdbcDao personJdbcDao;
	
	@GetMapping("/findAll")
	public List<Person> findAll()
	{
		_logger.info("-------------"+personJdbcDao.findAll());
		return personJdbcDao.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Person findById(@PathVariable("id") int id)
	{
		_logger.info("---------+++++++++++----"+personJdbcDao.findById(id));
		return personJdbcDao.findById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public int deleteById(@PathVariable("id") int id)
	{
		return personJdbcDao.deleteById(id);
	}
	
	@PostMapping("/insert")
	public int insert(@RequestBody Person person)
	{
		return personJdbcDao.insert(person);
	}
	
	@PutMapping("/update")
	public int update(@RequestBody Person person)
	{
		return personJdbcDao.update(person);
	}
}
