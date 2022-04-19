package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AppTest {
    EntityManager em;
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

    @Before
    public void init() {
        em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        em.persist(workTask);
        em.persist(homeTask);
        em.getTransaction().commit();
    }

    @Test
    public void hfd() {
        Task hm = em.find(Task.class, 2);
        assertEquals(homeTask, hm);
        Task wt = em.find(Task.class, 1);
        assertEquals(workTask, wt);
    }

    @After
    public void close() {
        HibernateUtil.closeFactory();
    }
}