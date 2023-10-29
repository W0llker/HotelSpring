package itAcadamy.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import itAcadamy.aspect.TransactionAspect;
import itAcadamy.mapper.ClientMapper;
import itAcadamy.scope.CustomScopeRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "itAcadamy")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "itAcadamy")
@PropertySource("application.properties")
public class ConfigClass {
    @Value("${server.url}")
    private String url;
    @Value("${server.driver}")
    private String driver;
    @Value("${server.login}")
    private String login;
    @Value("${server.password}")
    private String pass;
    @Value("${hibernate.packagesToScan}")
    private String packagesToScan;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.format_sql}")
    private boolean formatSql;
    @Value("${hibernate.show_sql}")
    private boolean showSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Bean
    public DataSource dataSource() {
        HikariConfig hc = new HikariConfig();
        hc.setDriverClassName(driver);
        hc.setJdbcUrl(url);
        hc.setUsername(login);
        hc.setPassword(pass);
        return new HikariDataSource(hc);
    }
    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        return properties;
    }
    // не работает с Spring Data
    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(packagesToScan);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.afterPropertiesSet();
        return localSessionFactoryBean.getObject();
    }
    @Bean
    @Scope(value = "close", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session session() throws IOException {
        return sessionFactory().openSession();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);
        localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return localContainerEntityManagerFactoryBean;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }
}
