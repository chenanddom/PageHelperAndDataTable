package com.pagetable.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pagetable.mapper.PersonMapper;
import com.pagetable.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageHelperAndDataTableService {
    @Autowired
    private PersonMapper personMapper;

    public Page<Person> findPersons(Integer pageIndex,Integer pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        return personMapper.findPersons();
    }
    public Integer insert(Person person){
        return personMapper.insert(person);
    }

}
