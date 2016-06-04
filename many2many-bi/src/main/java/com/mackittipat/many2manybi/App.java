package com.mackittipat.many2manybi;

import com.mackittipat.many2manybi.domain.Address;
import com.mackittipat.many2manybi.domain.Person;
import com.mackittipat.many2manybi.domain.PersonAddress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main( String[] args ) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myhibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person1 = new Person();
        Person person2 = new Person();

        Address address1 = new Address("12th Avenue", "12A");
        Address address2 = new Address("18th Avenue", "18B");

        entityManager.persist(person1);
        entityManager.persist(person2);

        entityManager.persist(address1);
        entityManager.persist(address2);

        PersonAddress personAddress1 = new PersonAddress(person1, address1);
        PersonAddress personAddress2 = new PersonAddress(person1, address2);
        PersonAddress personAddress3 = new PersonAddress(person2, address1);

        entityManager.persist(personAddress1);
        entityManager.persist(personAddress2);
        entityManager.persist(personAddress3);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
