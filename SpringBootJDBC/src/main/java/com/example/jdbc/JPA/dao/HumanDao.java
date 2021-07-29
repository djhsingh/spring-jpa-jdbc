package com.example.jdbc.JPA.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.example.jdbc.JPA.entity.Human;

import com.example.jdbc.models.Person;

@Repository
@Transactional
public class HumanDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Human> findAll()
	{
		TypedQuery<Human> namedQuery= entityManager.createNamedQuery("find_all",Human.class);
		return namedQuery.getResultList();
		
	}
	
	//select * from person where id=? 
	public Human findById(int id)
	{
		return entityManager.find(Human.class, id); 
	
	}
	
	public Human insert(Human human)
	{
		return entityManager.merge(human);
	}
	
	public Human update(Human human)
	{
		return entityManager.merge(human);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Human human = findById(id);
		 entityManager.remove(human);
	}
}
