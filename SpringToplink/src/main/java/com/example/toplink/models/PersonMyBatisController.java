package com.example.toplink.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonMyBatisController {
	
	@Autowired
	private PersonMyBatisRepo repo;
	
	@GetMapping("/findAll")
	public List<Person> findAll()
	{
		
		return repo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Person findById(@PathVariable("id") long id)
	{
		System.out.println("-------------"+ repo.findById(id));
		return repo.findById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id)
	{		
		 repo.deleteById(id);
		 System.out.println("Deleted Successfully!!!!!!!!");
	}
	
	@PostMapping("/insert")
	public Person insert(@RequestBody Person person)
	{
		System.out.println("In controller data is "+person);
		repo.insert(person);
		return person;
		
	}
	@PutMapping("/update")
	public Person update(@RequestBody Person person)
	{
		System.out.println("In controller data is "+person);
		repo.update(person);
		return person;
		
	}
	
	
}
