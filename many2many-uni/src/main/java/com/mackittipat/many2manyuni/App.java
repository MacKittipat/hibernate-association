package com.mackittipat.many2manyuni;

import com.mackittipat.many2manyuni.domain.Address;
import com.mackittipat.many2manyuni.domain.Person;

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

        Address address1 = new Address( "12th Avenue", "12A" );
        Address address2 = new Address( "18th Avenue", "18B" );

        person1.getAddresses().add(address1);
        person1.getAddresses().add(address2);

        person2.getAddresses().add(address1);

        entityManager.persist(person1);
        entityManager.persist(person2);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
