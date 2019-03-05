package com.devkuma.spring.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SampleEntityConfig
 */
@Configuration
@EnableJpaRepositories("com.devkuma.spring.db")
@EnableTransactionManagement
public class SampleEntityConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    // @Bean
    // public EntityManagerFactory factory() {
    //     HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    //     vendorAdapter.setGenerateDdl(true);

    //     LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    //     factory.setJpaVendorAdapter(vendorAdapter);
    //     factory.setPackagesToScan("com.devkuma.spring.db");
    //     factory.setDataSource(dataSource());
    //     factory.afterPropertiesSet();
    //     return factory.getObject();
    // }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.devkuma.spring.db");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory endtEntityManagerFactory) {
        return new JpaTransactionManager(endtEntityManagerFactory);
    }
}