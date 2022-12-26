package com.wzw.test.service;

import com.wzw.simple.SimpleApplication;
import com.wzw.simple.config.ApolloConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/24
 */
@SpringBootTest(classes = SimpleApplication.class)
@RunWith(SpringRunner.class)
public class TestService {
    @Autowired
    private ApolloConfig apolloConfig;

    @Test
    public void test(){
        System.out.println(apolloConfig.getEnv());
    }

}
