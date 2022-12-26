package com.wzw.simple.service.impl;

import com.wzw.simple.service.UserService;
import com.wzw.simple.user.mapper.UserMapper;
import com.wzw.simple.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }

    @Transactional(transactionManager = "UserTransactionManager", rollbackFor = Throwable.class)
    @Override
    public Boolean save(User user) {
        int save = userMapper.save(user);
        return save == 1;
    }

}
