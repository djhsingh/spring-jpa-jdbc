package com.example.toplink.models;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonMyBatisRepo {

	@Select("SELECT * FROM person WHERE id = #{id}")
	public Person findById(Long id);
	
	@Select("select * from person")
    public List <Person> findAll();
	
	 @Delete("DELETE FROM person WHERE id = #{id}")
	 public int deleteById(long id);
	 
	 @Insert("INSERT INTO person(id, name, age) " +
        " VALUES (#{id}, #{name}, #{age})")
    public int insert(Person person);

    @Update("Update person set name=#{name}, " +
        " age=#{age} where id=#{id}")
    public int update(Person person);
}
