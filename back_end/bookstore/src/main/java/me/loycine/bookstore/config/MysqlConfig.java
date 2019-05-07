package me.loycine.bookstore.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("me.loycine.bookstore.mapper")
public class MysqlConfig {

    @ConfigurationProperties(prefix = "app.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
}

