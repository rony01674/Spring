package com.project.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please enter your first name")
    @Size(min = 3, max = 50, message = "Name must between 3 to 30 characters")
    private String fname;

    @NotEmpty(message = "Please enter your last name")
    @Size(min = 3, max = 50, message = "Name must between 3 to 30 characters")
    private String lname;

    @NotEmpty(message = "Select your gender")
    private String gender;

    @NotEmpty(message = "Enter your birth date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date birthdate;

    @NotEmpty(message = "Enter your address")
    private String address;

    @NotEmpty(message = "Enter your city")
    private String city;

    @NotEmpty(message = "Enter your zip code")
    private String zipCode;

    @NotEmpty(message = "Enter your mobile number")
    private int mobileNo;

    @NotEmpty(message = "Enter yor email address")
    @Email(message = "Enter your valid email address")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Enter you national id number")
    private String nationalIdNumber;

    @NotEmpty(message = "Enter an user name")
    @Column(unique = true)
    private String userName;

    @NotEmpty(message = "Enter your password")
    private String password;

    @NotEmpty(message = "Upload your photo")
    private String imagePath;

    @NotEmpty(message = "Select a role")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @NotEmpty(message = "Select Joining Date")
    private Date joiningDate;
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
}
