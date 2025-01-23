package cn.poethan.ezcarcustomer.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "cn.poethan.ezcar.mapper")
public class MybatisPlusConfig {
    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "mysql.master", ignoreInvalidFields = true)
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "slave1DataSource")
    @ConfigurationProperties(prefix = "mysql.slave1",ignoreInvalidFields = true)
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "slave2DataSource")
    @ConfigurationProperties(prefix = "mysql.slave2",ignoreInvalidFields = true)
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(
            @Qualifier("masterDataSource") DataSource masterDataSourceConfig,
            @Qualifier("slave1DataSource") DataSource slave1DataSourceConfig,
            @Qualifier("slave2DataSource") DataSource slave2DataSourceConfig){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", masterDataSourceConfig);
        targetDataSources.put("slave1", slave1DataSourceConfig);
        targetDataSources.put("slave2", slave2DataSourceConfig);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSourceConfig);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSourceConfig) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSourceConfig);
        return bean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSourceConfig) {
        return new DataSourceTransactionManager(dynamicDataSourceConfig);
    }
}