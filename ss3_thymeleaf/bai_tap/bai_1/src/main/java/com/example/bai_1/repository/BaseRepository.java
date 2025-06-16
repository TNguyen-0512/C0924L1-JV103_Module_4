package com.example.bai_1.repository;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import org.hibernate.cfg.Configuration;

@Component
public class BaseRepository {
    private static SessionFactory sessionFactory;
    static EntityManager entityManager;


    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
