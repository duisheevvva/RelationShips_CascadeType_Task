package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfig {
    public static EntityManager getEntityManager() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty(DRIVER, "org.postgresql.Driver");
            configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
            configuration.setProperty(USER, "postgres");
            configuration.setProperty(PASS, "1234");
            configuration.setProperty(HBM2DDL_AUTO, "create");
            configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty(SHOW_SQL, "true");
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Publisher.class);
            configuration.addAnnotatedClass(Reader.class);
            return configuration.buildSessionFactory().createEntityManager();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
