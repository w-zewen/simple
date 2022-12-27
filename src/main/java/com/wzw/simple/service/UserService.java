package com.wzw.simple.service;

import com.wzw.simple.bean.Paging;
import com.wzw.simple.user.model.User;

import java.util.List;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/26
 */
public interface UserService {
    List<User> list();

    Boolean save(User user);

    Paging<List<User>> page(String username, Integer pageNo, Integer pageSize);
}
