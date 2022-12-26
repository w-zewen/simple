package com.wzw.simple.controller;

import com.wzw.simple.bean.Response;
import com.wzw.simple.service.UserService;
import com.wzw.simple.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public Response<List<User>> list(){
        List<User> list = userService.list();
        return Response.success(list);
    }

    @RequestMapping("/save")
    public Response<Boolean> save(@RequestBody User user){
        Boolean r = userService.save(user);
        return Response.success(r);
    }

}
