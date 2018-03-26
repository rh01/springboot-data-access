package com.readailib.springbootdataaccess.dao;


import com.readailib.springbootdataaccess.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // 1. 方法名查询，定义根据地址查询的方法
    List<Person> findByAddress(String name);

    //2. 使用方法名来查询，根据姓名和地址查询
    Person findByNameAndAddress(String name, String Address);

    //3. 参数按照名称绑定
    @Query("select p from  Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    //4. named查询
    // 和实体类对应
    Person withNameAndAddressNamedQuery(String name, String address);

}
