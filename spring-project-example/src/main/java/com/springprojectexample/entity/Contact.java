package com.springprojectexample.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class Contact {

    @Id     //All annotation will be imported from javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(name = "first_name", unique = true, nullable = false)
    //table name is not required, but column annotation required coz of unique, nullable and other more fields
    @Size(min = 3, max = 15)        // all validation field will be used form javax.validation.constraints
    private String firstName;

    @Temporal(TemporalType.DATE)
    //temporal annotation is required for showing the type of date like: show only date or date and time also
    private Date birthDate;     //always use java.util.Date\

    @Column(unique = true, nullable = false)
    private String mobileNo;

    // Set and mapped is used when necessary
    @OneToMany(mappedBy = "contact")        //this "mappedBy = contact" object come from contact details entity class
    //one contact has many details..that's why relation is "OneToMany relation"
    private Set<ContactDetails> contactDetails;

    @OneToMany(mappedBy = "contacts") // this "mappedBy = contacts" object come from hobby entity class
    private Set<Hobby> hobbies;

    @OneToOne       // This will create a foreign key of Student id
    @JoinColumn(name = "stu_id")
    private Student student;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Set<ContactDetails> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Set<ContactDetails> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
