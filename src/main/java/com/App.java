package com;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        HomeTask homeTask = HomeTask.builder()
                .name("Hibernate")
                .description("myWork")
                .startDate(LocalDate.of(2022, 4, 17))
                .endDate(LocalDate.of(2022, 4, 19))
                .caretaker(Person.builder()
                        .name("Sergei")
                        .surname("Rusakovich")
                        .build())
                .executor(Person.builder()
                        .name("Nikolai")
                        .surname("Rogovtsov")
                        .build())
                .build();
        WorkTask workTask = WorkTask.builder()
                .name("Hibernate")
                .description("myWork")
                .cost(1000)
                .build();
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        em.persist(workTask);
        em.persist(homeTask);
        em.getTransaction().commit();
        HibernateUtil.closeFactory();
    }
}
