package com.mackittipat.one2onebi;

import com.mackittipat.one2onebi.domain.Phone;
import com.mackittipat.one2onebi.domain.PhoneDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main( String[] args ) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myhibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Phone phone = new Phone("123");

        PhoneDetail phoneDetail = new PhoneDetail("provider", "technology");
        phoneDetail.setPhone(phone);

        phone.setPhoneDetail(phoneDetail);
        entityManager.persist(phone);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
