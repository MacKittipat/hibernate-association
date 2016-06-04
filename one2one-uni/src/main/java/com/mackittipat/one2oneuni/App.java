package com.mackittipat.one2oneuni;

import com.mackittipat.one2oneuni.domain.Phone;
import com.mackittipat.one2oneuni.domain.PhoneDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main( String[] args ) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myhibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        PhoneDetail phoneDetail = new PhoneDetail("provider", "technology");
        entityManager.persist(phoneDetail);
        
        Phone phone = new Phone("123");
        phone.setPhoneDetail(phoneDetail);
        entityManager.persist(phone);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
