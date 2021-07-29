package com.example.jdbc.JPA.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.JPA.dao.HumanDao;
import com.example.jdbc.JPA.entity.Human;
import com.example.jdbc.daoForJdbc.PersonJdbcDao;
import com.example.jdbc.models.Person;

@RestController
@RequestMapping("/jpa")
public class HumanRestController {

private Logger _logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HumanDao humanDao;
	
	@GetMapping("/findAll")
	public List<Human> findAll()
	{
		
		_logger.info("-------------"+humanDao.findAll());
		return humanDao.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public JSONObject findById(@PathVariable("id") int id)
	{
		
		Human human = humanDao.findById(id);
		_logger.info("---------+++++++++++----"+human);
		JSONObject obj = new JSONObject(human);
		_logger.info("---------+++++++++++----"+obj);
		if(obj.isNull(""))
		{
			return null;
		}
		return obj;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") int id)
	{
		 humanDao.deleteById(id);
	}
	
	@PostMapping("/insert")
	public Human insert(@RequestBody Human human)
	{
		return humanDao.insert(human);
	}
	
	@PutMapping("/update")
	public Human update(@RequestBody Human human)
	{
		return humanDao.update(human);
	}
}
