package com.pagetable.mapper;

import com.github.pagehelper.Page;
import com.pagetable.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {

public Page<Person> findPersons();

public Integer insert(Person person);
}
