package com.springprojectexample.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany // In case of ManyToMany relation, there will be relation between two tables
    @JoinTable(name = "hobby_contact",
                joinColumns = @JoinColumn(name = "hobby_id"),
                inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Set<Contact> contacts;
}
