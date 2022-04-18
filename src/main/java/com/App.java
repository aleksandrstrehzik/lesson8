package com;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        HomeTask homeTask = HomeTask.builder()
                .caretaker(Person.builder()
                        .name("Sergei")
                        .surname("Rusakovich")
                        .build())
                .executor(Person.builder()
                        .name("Nikolai")
                        .surname("Rogovtsov")
                        .build())
                .build();
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        em.persist(homeTask);
        HibernateUtil.closeFactory();
    }
}
