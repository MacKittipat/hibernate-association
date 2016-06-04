package com.mackittipat.many2manybi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "personaddress")
public class PersonAddress implements Serializable {

    @Id
    @ManyToOne
    private Person person;

    @Id
    @ManyToOne
    private Address address;

    public PersonAddress() {
    }

    public PersonAddress(Person person, Address address) {
        this.person = person;
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
