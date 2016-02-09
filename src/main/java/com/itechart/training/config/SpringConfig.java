package com.itechart.training.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zhenya on 04.02.16.
 */
@Configuration
@ComponentScan(basePackages = "com.itechart.training")
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(hibernateProperties());
        factory.setPackagesToScan(
                new String[] { "com.itechart.training.models" });
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public DataSource dataSource() {
            final HikariDataSource ds = new HikariDataSource();
            ds.setMaximumPoolSize(100);
            ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
            ds.addDataSourceProperty("url", "jdbc:mysql://localhost:3306/students2");
            ds.addDataSourceProperty("user", "root");
            ds.addDataSourceProperty("password", "");
            ds.addDataSourceProperty("cachePrepStmts", true);
            ds.addDataSourceProperty("prepStmtCacheSize", 250);
            ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
            ds.addDataSourceProperty("useServerPrepStmts", true);

        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
                "validate");
        hibernateProperties.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLInnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql",
                "true");
        return hibernateProperties;
    }
}
