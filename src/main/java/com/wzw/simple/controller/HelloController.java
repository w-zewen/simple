package com.wzw.simple.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/23
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam(name = "name", required = false) String name){
        return "hello word " + name;
    }

}
