package com.wzw.simple.store.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 店铺库数据源配置
 *
 * @author zewen.wang
 * @date 2022/12/24
 */
@Configuration
@MapperScan(basePackages = "com.wzw.simple.store.mapper", sqlSessionFactoryRef = "StoreSqlSessionFactory")
public class StoreDatabaseConfig {

    @Bean(name = "StoreDB")
    @ConfigurationProperties(prefix = "spring.datasource.store")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "StoreSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:store/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "StoreTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}
