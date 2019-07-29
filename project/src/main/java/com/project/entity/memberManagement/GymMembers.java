package com.project.entity.memberManagement;

import com.project.entity.ClassTime;
import com.project.entity.User;
import com.project.entity.membershipType.MembershipType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class GymMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @NotEmpty(message = "Enter Your Name")
    @Size(min = 3, max = 50, message = "Name must between 3 to 50 characters")
    private String memberName;

    @NotEmpty(message = "Enter your Fathers name")
    private String fathersName;

    @NotEmpty(message = "Select your gender")
    private String gender;

    @NotEmpty(message = "Enter your Birth date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyy")
    private Date birthDate;

    @NotEmpty(message = "Enter your address")
    private String address;

    @NotEmpty(message = "Enter your city")
    private String city;

    @NotEmpty(message = "Enter your zip code")
    private int zipCode;

    @NotEmpty(message = "Enter your mobile number")
    @Column(unique = true)
    private int mobile;

    @NotEmpty(message = "Enter your email address")
    @Email(message = "Enter your valid email address")
    private String email;

    @NotEmpty(message = "Enter your weight")
    private int weight;

    @NotEmpty(message = "Enter your height")
    private int height;

    @NotEmpty(message = "Enter your chest size")
    private int chest;

    @NotEmpty(message = "Enter your waist size")
    private int waist;

    @NotEmpty(message = "Enter your thigh size")
    private int thigh;

    @NotEmpty(message = "Enter your arms size")
    private int arms;

    @NotEmpty(message = "Enter your fat percentage ")
    private String fat;

    @NotEmpty(message = "Enter your user name")
    @Column(unique = true)
    private String userName;

    @NotEmpty(message = "Enter your password")
    private String password;

    @NotEmpty(message = "Select Image")
    private String imagePath;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty(message = "Select members goal")
    private String membersGoal;

    @NotEmpty(message = "Select trial start date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date inquiryDate;

    @NotEmpty(message = "Select trial end date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date trialEndDate;

    @NotEmpty(message = "Select member type")
    private String memberType;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_type_id")
    private MembershipType membershipType;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private ClassTime classTimes;

    @NotEmpty(message = "Select joining date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyy")
    private Date joiningDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyy")
    private Date endDate;

    @NotEmpty(message = "Enter first payment date")
    private Date firstPaymentDate;


    public GymMembers() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public int getWaist() {
        return waist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getThigh() {
        return thigh;
    }

    public void setThigh(int thigh) {
        this.thigh = thigh;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
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


    public String getMembersGoal() {
        return membersGoal;
    }

    public void setMembersGoal(String membersGoal) {
        this.membersGoal = membersGoal;
    }

    public Date getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(Date inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public Date getTrialEndDate() {
        return trialEndDate;
    }

    public void setTrialEndDate(Date trialEndDate) {
        this.trialEndDate = trialEndDate;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public ClassTime getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(ClassTime classTimes) {
        this.classTimes = classTimes;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }
}
