package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("HomeWork");

    public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }

    public static void closeFactory(){
        factory.close();
    }

}
