package com.readailib.girl.service;

import com.readailib.girl.domain.Girl;
import com.readailib.girl.respository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * @program: girl
 * @description: GirlService
 * @Author: ReadAILib
 * @create: 2018-03-21 09:54
 **/
@Service

public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

   @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBB");
        girlB.setAge(18);
        girlRepository.save(girlB);


    }
}
