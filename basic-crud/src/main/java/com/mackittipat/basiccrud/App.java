package com.mackittipat.basiccrud;

import com.mackittipat.basiccrud.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myhibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person p1 = new Person("Mac", 27);
        Person p2 = new Person("Pea", 37);
        Person p3 = new Person("Pun", 31);
        Person p4 = new Person("Kai", 31);

        // INSERT
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.persist(p4);

        entityManager.getTransaction().commit();

        // READ
        Person person = entityManager.createQuery("SELECT p FROM Person p WHERE name=:name", Person.class)
                .setParameter("name", "Mac")
                .getSingleResult();
        System.out.println("Find Mac = " + person);

        List<Person> personList = entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        System.out.println("personList's size = " + personList.size());

        person = entityManager.find(Person.class, 2L);
        System.out.println("Find second person = " + person);


        entityManager.getTransaction().begin();
        // UPDATE
        p1 = entityManager.find(Person.class, 1L);
        p1.setName("Mac2");
        entityManager.getTransaction().commit();
        System.out.println("Find first person = " + p1);

        entityManager.getTransaction().begin();
        // DELETE
        entityManager.remove(p1);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
