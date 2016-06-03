package com.mackittipat.one2manyuni;

import com.mackittipat.one2manyuni.domain.Person;
import com.mackittipat.one2manyuni.domain.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main( String[] args ) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myhibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person = new Person();
        person.getPhoneList().add(new Phone("123"));
        person.getPhoneList().add(new Phone("456"));
        entityManager.persist(person);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
