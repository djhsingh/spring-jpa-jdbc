package com.example.jdbc.daoForJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jdbc.models.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//select * from person
	public List<Person> findAll()
	{
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}
	
	//select * from person where id=? 
	public Person findById(int id)
	{
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object [] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//delete  from person where id=? 
		public int deleteById(int id)
		{
			return jdbcTemplate.update("delete from person where id=?", new Object [] {id});
		}
		
//insert into PERSON (name, location, birth_date) values ('raj', 'punjab', CURRENT_TIMESTAMP);
		public int insert(Person person)
		{
			return  jdbcTemplate.update("insert into PERSON (name, location, birth_date) values (?, ?, ?)", new Object [] {person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime())});
		}
		
		//insert into PERSON (name, location, birth_date) values ('raj', 'punjab', CURRENT_TIMESTAMP);
		public int update(Person person)
		{
			return  jdbcTemplate.update("update PERSON set name=?, location=?, birth_date=? where id=?", new Object [] {person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime()),person.getId()});
		}
}
class PersonRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setLocation(rs.getString("location"));
		person.setBirth_date(rs.getTimestamp("birth_date"));
		return person;
	}
	
}