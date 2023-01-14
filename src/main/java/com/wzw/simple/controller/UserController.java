package com.wzw.simple.controller;

import com.alibaba.fastjson2.JSONObject;
import com.wzw.simple.bean.Paging;
import com.wzw.simple.bean.Response;
import com.wzw.simple.service.UserService;
import com.wzw.simple.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/26
 */
@Slf4j
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

    @RequestMapping("page")
    public Response<Paging<List<User>>> page(@RequestParam(name = "username", required = false) String username,
                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        log.info("UserController page in username={}, pageNo={}, pageSize={}", username, pageNo, pageSize);
        Paging<List<User>> page = userService.page(username, pageNo, pageSize);
        log.info("UserController page out result={}", JSONObject.toJSONString(page));
        return Response.success(page);
    }

}
