package com.demoproject.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter your name")
    @Size(min = 3, max = 30, message = "Name must between 3 to 30")
    private String name;

    @NotEmpty(message = "Enter an User name")
    @Column(unique = true)
    private String userName;

    @NotEmpty(message = "Enter your Age")
    private int age;

    @NotEmpty(message = "Select your gender")
    private String gender;

    @NotEmpty(message = "Enter an email address")
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Enter your mobile number")
    @Min(value = 11)
    @Column(unique = true)
    private int mobile;

    @NotEmpty(message = "Enter your birthday")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyy")
    private Date birthday;

    @NotEmpty(message = "Select a Role")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@NotEmpty(message = "Enter your name") @Size(min = 3, max = 30, message = "Name must between 3 to 30") String name, @NotEmpty(message = "Enter an User name") String userName, @NotEmpty(message = "Enter your Age") int age, @NotEmpty(message = "Select your gender") String gender, @NotEmpty(message = "Enter an email address") @Email String email, @NotEmpty(message = "Enter your mobile number") @Min(value = 11) int mobile, @NotEmpty(message = "Enter your birthday") Date birthday, @NotEmpty(message = "Select a Role") Set<Role> roles) {
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.birthday = birthday;
        this.roles = roles;
    }

    public User(User user) {
        this.name = user.name;
        this.userName = user.userName;
        this.age = user.age;
        this.gender = user.gender;
        this.email = user.email;
        this.mobile = user.mobile;
        this.birthday = user.birthday;
        this.roles = user.roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
