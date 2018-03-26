package com.readailib.springbootdataaccess.controller;

import com.readailib.springbootdataaccess.dao.PersonRepository;
import com.readailib.springbootdataaccess.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

/*
 * @program: springboot-data-access
 * @description: 业务逻辑
 * @Author: ReadAILib
 * @create: 2018-03-26 10:02
 **/
@RestController
public class DataController {

    //1. 注入PersonRepositoryBean
    @Autowired
    PersonRepository personRepository;

    /**
    * @Description: 支持批量保存
    * @Param: [name, address, age]
    * @return: com.readailib.springbootdataaccess.domain.Person
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping(value = "/save")
    public Person save(String name, String address, Integer age) {
        Person p = personRepository.save(new Person(null, name, age, address));
        return p;
    }

    /**
    * @Description: 测试findByAddress
    * @Param: [address]
    * @return: java.util.List<com.readailib.springbootdataaccess.domain.Person>
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping("/q1")
    public List<Person> q1(String address){
        return personRepository.findByAddress(address);
    }

    /**
    * @Description: 测试findByNameAndAddress
    * @Param: [name, address]
    * @return: com.readailib.springbootdataaccess.domain.Person
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping("/q2")
    public Person q2(String name, String address){
        return personRepository.findByNameAndAddress(name, address);
    }

    /**
    * @Description: 测试withNameAndAddressQuery
    * @Param: [name, address]
    * @return: com.readailib.springbootdataaccess.domain.Person
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping("/q3")
    public Person q3(String name, String address){
        return personRepository.withNameAndAddressQuery(name, address);
    }

    /**
    * @Description: 测试withNameAndAddressNameQuery
    * @Param: [name, address]
    * @return: com.readailib.springbootdataaccess.domain.Person
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping("/q4")
    public Person q4(String name, String address){
        return personRepository.withNameAndAddressNamedQuery(name, address);
    }

    /**
    * @Description: 按照age排序
    * @Param: []
    * @return: java.util.List<com.readailib.springbootdataaccess.domain.Person>
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping("/sort")
    public List<Person> sort(){
        return personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
    }

    /**
    * @Description: 测试分页
    * @Param: []
    * @return: org.springframework.data.domain.Page<com.readailib.springbootdataaccess.domain.Person>
    * @Author: ReadAILib
    * @Date: 2018/3/26
    */
    @RequestMapping("/page")
    public Page<Person> page(){
        return personRepository.findAll(of(1,2));
    }

}
