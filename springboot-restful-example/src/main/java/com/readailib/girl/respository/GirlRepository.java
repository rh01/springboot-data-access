package com.readailib.girl.respository;


import com.readailib.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GirlRepository extends JpaRepository<Girl,Integer>{

    /**
    * @Description: Find girls by age
    * @Param: [age]
    * @return: java.util.List<com.readailib.girl.domain.Girl>
    * @Author: ReadAILib
    * @Date: 2018/3/20
    */
    public List<Girl> findByAge(Integer age);
}
