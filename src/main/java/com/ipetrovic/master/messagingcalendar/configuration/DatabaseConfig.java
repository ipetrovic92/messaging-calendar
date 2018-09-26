package com.ipetrovic.master.messagingcalendar.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory factory) throws Exception {
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(PersistenceUnitManager persistenceUnitManager, JpaVendorAdapter jpaVendorAdapter, DataSource datasource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        Properties properties = new Properties();
        properties.put("hibernate.listeners.envers.autoRegister", "false");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.default_batch_fetch_size", "9");
        properties.put("hibernate.max_fetch_depth", "3");
//        properties.put("cache.use_second_level_cache", "true");
//        properties.put("cache.use_query_cache", "true");
        properties.put("hibernate.id.new_generator_mappings", "true");
        factory.setJpaProperties(properties);
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setPersistenceUnitManager(persistenceUnitManager);
        factory.setDataSource(datasource);

        return factory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setDatabasePlatform(PostgreSQL9Dialect.class.getName());
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);

        return adapter;
    }

    @Bean
    PersistenceUnitManager persistenceUnitManager(DataSource datasource) {
        DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
        persistenceUnitManager.setDefaultPersistenceUnitName("kalendar");
        persistenceUnitManager.setDefaultDataSource(datasource);
        persistenceUnitManager.setPackagesToScan("com.ipetrovic.master.messagingcalendar");
        persistenceUnitManager.setSharedCacheMode(SharedCacheMode.DISABLE_SELECTIVE);
        persistenceUnitManager.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return persistenceUnitManager;
    }

}
