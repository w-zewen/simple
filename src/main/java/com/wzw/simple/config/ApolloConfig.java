package com.wzw.simple.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/24
 */
@Data
@Configuration
@EnableApolloConfig({"application", "business"})
public class ApolloConfig {

    @Value("${simple.env}")
    private String env;

}
