package com.wzw.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzw.simple.bean.Paging;
import com.wzw.simple.service.UserService;
import com.wzw.simple.user.mapper.UserMapper;
import com.wzw.simple.user.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

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

    @Override
    public Paging<List<User>> page(String username, Integer pageNo, Integer pageSize) {
        Example.Builder builder = Example.builder(User.class);
        WeekendSqls<User> weekendSql = WeekendSqls.custom();
        if(StringUtils.isNotEmpty(username)){
            weekendSql.andLike(User::getUserName, "%"+username+"%");
        }
        builder.andWhere(weekendSql);
        builder.orderByDesc("id");
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.selectByExample(builder.build());
        PageInfo pageInfo = new PageInfo(list);
        return new Paging(pageInfo.getTotal(), list);
    }

}
