package com.pagetable.controller;

import com.github.pagehelper.Page;
import com.pagetable.model.Person;
import com.pagetable.page.PageInfo;
import com.pagetable.service.PageHelperAndDataTableService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageHelperAndDataTableController {
    @Autowired
    PageHelperAndDataTableService pageHelperAndDataTableService;

    @RequestMapping(value = "/addPerson",method = RequestMethod.GET)
    public Integer addPersonInfo(){
        Integer subFlag=0;
        for (int i=0;i<100;i++){
            Person person = new Person();
            person.setId(100L+i);
            person.setName("zhangsan"+i);
            person.setAge(((int)(Math.random()*100)));
            person.setAddress("address"+i);
            subFlag+=pageHelperAndDataTableService.insert(person);
        }
        return subFlag==null?0:subFlag;
    }



    @RequestMapping(value = "/getPersonsByCondition",method = RequestMethod.POST)
    public PageInfo<Person> getPersons(@RequestParam(required = false, name = "pageSize") Integer pageSize,
                                       @RequestParam(required = false, name = "startIndex") Integer startIndex,
                                       @RequestParam(required = false, name = "pageIndex") Integer pageIndex){
        Page<Person> personPage = pageHelperAndDataTableService.findPersons(pageIndex,pageSize);
        PageInfo<Person> pageInfo = new PageInfo<Person>(personPage);
    return pageInfo;
}

}
