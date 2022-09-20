/**
 * <p> 
 * Package for util class 
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.util;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Trainer;
import com.ideas2it.employee.model.Trainee;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 

/**
 * <p>
 * This class is responsible for configuring the connection between
 * our application and database. it contains session factory interface 
 * and it return session.
 *
 * @author RithiKanth B C
 * @since 23/01/2022
 */
public class ConnectionUtil {
    private static ConnectionUtil connectionUtil;
    private static Session session = null ;

    private ConnectionUtil() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Trainer.class);
            configuration.addAnnotatedClass(Trainee.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            session  = sessionFactory.openSession();
        } catch(HibernateException hibernateException) {
              throw new HibernateException(hibernateException.getMessage() + "connection failed");
        }               
    }

    public static Session createConnection()  {       
        if (session == null || !session.isOpen()) {
            connectionUtil  =  new  ConnectionUtil();              
        }
        return session;
    }
}