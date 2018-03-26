package com.readailib.girl.controller;

import com.readailib.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value ="/say/{id}", method = RequestMethod.GET)
    //@RequestMapping(value ="/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String sayHello(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "id: " + myId;
    }
}
