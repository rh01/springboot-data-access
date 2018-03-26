package com.readailib.springbootredis.web;

import com.readailib.springbootredis.dao.Person;
import com.readailib.springbootredis.domain.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @program: springboot-redis
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-26 11:20
 **/
@RestController
public class DataController {
    @Autowired
    PersonDao personDao;

    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1", "wyf",32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
