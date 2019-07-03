package com.springprojectexample.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private String telType;

    private String telNumber;

    @ManyToOne       // this annotation declare the relation between Contact table and Contact_details table==
                    //one contact has many details..that's why relation is "ManyToOne relation"
    @JoinColumn(name = "contact_id")        // contact_id will be created as a foreign key from contact table
    private Contact contact;         //Contact class object created


}
