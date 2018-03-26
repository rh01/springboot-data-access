package com.readailib.girl.controller;

import com.readailib.girl.domain.Girl;
import com.readailib.girl.respository.GirlRepository;
import com.readailib.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * @Description: 查看所有女生
     * @Param: []
     * @return: java.util.List<com.readailib.girl.domain.Girl>
     * @Author: ReadAILib
     * @Date: 2018/3/20
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }


    /**
     * @Description: 增加一个女生
     * @Param: [cupSize, age]
     * @return: com.readailib.girl.domain.Girl
     * @Author: ReadAILib
     * @Date: 2018/3/20
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    /**
     * @Description: 查询一位女生
     * @Param:
     * @return:
     * @Author: ReadAILib
     * @Date: 2018/3/20
     */
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }


    /**
     * @Description: 更新
     * @Param:
     * @return:
     * @Author: ReadAILib
     * @Date: 2018/3/20
     */
    @PutMapping(value = "girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * @Description: Delete a girl by id
     * @Param:
     * @return:
     * @Author: ReadAILib
     * @Date: 2018/3/20
     */
    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * @Description: Find all girls by their age
     * @Param: [age]
     * @return: java.util.List<com.readailib.girl.domain.Girl>
     * @Author: ReadAILib
     * @Date: 2018/3/20
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);

    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
