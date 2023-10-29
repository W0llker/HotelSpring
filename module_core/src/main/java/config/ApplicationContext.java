package config;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class ApplicationContext {
    private final static StandardServiceRegistryBuilder service;
    private final static Configuration configuration;
    private static ApplicationContext applicationContext;

    private ApplicationContext() {
    }

    static {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver.class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/testdb?currentSchema=hotel");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "nik981ita413");

        //кэш настройки
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.use_query_cache", "true");

        properties.setProperty("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
        properties.setProperty("net.sf.ehcache.configurationResourceName", "META-INF/config/ehcache.xml");

        properties.setProperty("hibernate.show_sql", "true");
        configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Hotel.class);
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(FeedBack.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(OrderHotel.class);
        configuration.addAnnotatedClass(Amenities.class);
        configuration.addAnnotatedClass(Administrative.class);
        service = new StandardServiceRegistryBuilder();
        service.applySettings(properties);
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = configuration.buildSessionFactory(service.build());
        return sessionFactory;
    }
}
