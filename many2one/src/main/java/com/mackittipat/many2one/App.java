package com.mackittipat.many2one;

import com.mackittipat.many2one.domain.Person;
import com.mackittipat.many2one.domain.Phone;

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
        entityManager.persist(person);

        Phone phone = new Phone("123-456-7890");
        phone.setPerson(person);
        entityManager.persist(phone);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
