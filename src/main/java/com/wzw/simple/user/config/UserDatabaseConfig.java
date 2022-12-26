package com.wzw.simple.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// 使用tk.mybatis这里要使用tk.mybatis.spring.annotation.MapperScan而不是mybatis原生的org.mybatis.spring.annotation.MapperScan
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 用户库数据源配置
 *
 * @author zewen.wang
 * @date 2022/12/24
 */
@Configuration
@MapperScan(basePackages = "com.wzw.simple.user.mapper", sqlSessionFactoryRef = "UserSqlSessionFactory")
public class UserDatabaseConfig {

    @Bean(name = "UserDB")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "UserSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        // new PathMatchingResourcePatternResolver().getResource() 方法只能精确获取文件，不能使用通配符
        // new PathMatchingResourcePatternResolver().getResources() 方法才能使用通配符
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:user/*.xml"));
        // 设置超时时间，决定驱动等待数据库响应的秒数（秒值，超过设置值自动中断SQL执行）
        sqlSessionFactoryBean.getObject().getConfiguration().setDefaultStatementTimeout(1);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "UserTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}
