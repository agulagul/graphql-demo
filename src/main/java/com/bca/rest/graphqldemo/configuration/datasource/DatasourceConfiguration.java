package com.bca.rest.graphqldemo.configuration.datasource;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.bca.rest.graphqldemo.configuration.logging.BaseLogging;

@Configuration
@EnableJpaRepositories(basePackages = "com.bca.rest.graphqldemo.repository", entityManagerFactoryRef = "demoEntityManager", transactionManagerRef = "demoTransactionManager")
@DependsOn("baseLogging")
public class DatasourceConfiguration extends BaseLogging {
    @Value("${application.localDev:true}")
    boolean localDev;

    @Value("${datasource.jndi.url}")
    String jndiUrl;

    @Value("${datasource.jdbc.url}")
    String jdbcUrl;

    @Value("${datasource.jdbc.username}")
    String jdbcUsername;

    @Value("${datasource.jdbc.password}")
    String jdbcPassword;

    @Value("${datasource.autoddl:none}")
    private String autoDdl;

    @Bean("demoEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.bca.rest.graphqldemo.model.dao");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        final HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());

        properties.put("hibernate.hbm2ddl.auto", autoDdl);
        if (localDev) {
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
        }
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean("demoDatasource")
    public DataSource dataSource() {
        if (localDev) {
            transLog.info("Using JDBC Connection: {}", jdbcUrl);
            return DataSourceBuilder.create().url(jdbcUrl).username(jdbcUsername).password(jdbcPassword).build();
        }

        transLog.info("Using JNDI Connection: {}", jndiUrl);
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource(jndiUrl);
    }

    @Bean("demoTransactionManager")
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManager().getObject());
        return jpaTransactionManager;
    }
}
