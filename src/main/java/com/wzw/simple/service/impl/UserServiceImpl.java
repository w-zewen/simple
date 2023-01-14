package com.wzw.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzw.simple.bean.Paging;
import com.wzw.simple.service.UserService;
import com.wzw.simple.user.mapper.UserMapper;
import com.wzw.simple.user.model.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }

    /**
     * spring的事务实现是通过AOP生成代理，所以必须在容器管理的方法上使用@Transactional才能有效开启事务
     */
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
        /**
         * 开始分页
         *
         * @param pageNum      页码
         * @param pageSize     每页显示数量
         * @param count        是否进行count查询
         * @param reasonable   分页合理化,null时用默认配置
         *          开启后会自动调整不合理的分页信息（比如pageNum<1会查询第一页，pageNum>最后一页会查询最后一页。会保证一定查出数据，在循环分页处理时可能导致死循环。一般关闭）
         * @param pageSizeZero true且pageSize=0时返回全部结果，false时分页,null时用默认配置
         * public static <E> Page<E> startPage(int pageNum, int pageSize, boolean count, Boolean reasonable, Boolean pageSizeZero)
         */
        List<User> list = userMapper.selectByExample(builder.build());
        log.info("page list size={}", list.size());
        PageInfo pageInfo = new PageInfo(list);
        return new Paging(pageInfo.getTotal(), list);
    }

}
