package com.demoproject.entity.memberManagement;

import com.demoproject.entity.mebershipTypeManagement.MembersGoal;
import com.demoproject.entity.attendanceManagement.ClassSchedule;
import com.demoproject.entity.mebershipTypeManagement.MembershipType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mName;
    private String mFatherName;
    private String mGender;
    private String mBirthday;
    private String mAddress;
    private String mCity;
    private String mZipCode;
    @Column(unique = true)
    private String mMobileNo;
    @Column(unique = true)
    private String mEmail;
    private int mWeight;
    private String mHeight;
    private int mChest;
    private int mWaist;
    private int mThigh;
    private int mArms;
    private String mFat;

    //For image upload
    private String photo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "m_goal",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "member_goal_id")
    )
    private MembersGoal mGoal;

    private String mType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "m_type",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "member_type_id")
    )
    private MembershipType membershipType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "m_class",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "member_class_id")
    )
    private ClassSchedule classTime;

    private String mStartDate;
    private String mEndDate;
    private String mFirstPayment;

    public Members() {
    }

    public Members(Long id) {
        this.id = id;
    }

    public Members(Members members) {
        this.mName = members.mName;
        this.mFatherName = members.mFatherName;
        this.mGender = members.mGender;
        this.mBirthday = members.mBirthday;
        this.mAddress = members.mAddress;
        this.mCity = members.mCity;
        this.mZipCode = members.mZipCode;
        this.mMobileNo = members.mMobileNo;
        this.mEmail = members.mEmail;
        this.mWeight = members.mWeight;
        this.mHeight = members.mHeight;
        this.mChest = members.mChest;
        this.mWaist = members.mWaist;
        this.mThigh = members.mThigh;
        this.mArms = members.mArms;
        this.mFat = members.mFat;
        this.photo = members.photo;
        this.mGoal = members.mGoal;
        this.mType = members.mType;
        this.membershipType = members.membershipType;
        this.classTime = members.classTime;
        this.mStartDate = members.mStartDate;
        this.mEndDate = members.mEndDate;
        this.mFirstPayment = members.mFirstPayment;
    }

    public Members(String mName, String mFatherName, String mGender, String mBirthday, String mAddress, String mCity, String mZipCode, String mMobileNo, String mEmail, int mWeight, String mHeight, int mChest, int mWaist, int mThigh, int mArms, String mFat, String photo, MembersGoal mGoal, String mType, MembershipType membershipType, ClassSchedule classTime, String mStartDate, String mEndDate, String mFirstPayment) {
        this.mName = mName;
        this.mFatherName = mFatherName;
        this.mGender = mGender;
        this.mBirthday = mBirthday;
        this.mAddress = mAddress;
        this.mCity = mCity;
        this.mZipCode = mZipCode;
        this.mMobileNo = mMobileNo;
        this.mEmail = mEmail;
        this.mWeight = mWeight;
        this.mHeight = mHeight;
        this.mChest = mChest;
        this.mWaist = mWaist;
        this.mThigh = mThigh;
        this.mArms = mArms;
        this.mFat = mFat;
        this.photo = photo;
        this.mGoal = mGoal;
        this.mType = mType;
        this.membershipType = membershipType;
        this.classTime = classTime;
        this.mStartDate = mStartDate;
        this.mEndDate = mEndDate;
        this.mFirstPayment = mFirstPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmFatherName() {
        return mFatherName;
    }

    public void setmFatherName(String mFatherName) {
        this.mFatherName = mFatherName;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmBirthday() {
        return mBirthday;
    }

    public void setmBirthday(String mBirthday) {
        this.mBirthday = mBirthday;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmZipCode() {
        return mZipCode;
    }

    public void setmZipCode(String mZipCode) {
        this.mZipCode = mZipCode;
    }

    public String getmMobileNo() {
        return mMobileNo;
    }

    public void setmMobileNo(String mMobileNo) {
        this.mMobileNo = mMobileNo;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmWeight() {
        return mWeight;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public String getmHeight() {
        return mHeight;
    }

    public void setmHeight(String mHeight) {
        this.mHeight = mHeight;
    }

    public int getmChest() {
        return mChest;
    }

    public void setmChest(int mChest) {
        this.mChest = mChest;
    }

    public int getmWaist() {
        return mWaist;
    }

    public void setmWaist(int mWaist) {
        this.mWaist = mWaist;
    }

    public int getmThigh() {
        return mThigh;
    }

    public void setmThigh(int mThigh) {
        this.mThigh = mThigh;
    }

    public int getmArms() {
        return mArms;
    }

    public void setmArms(int mArms) {
        this.mArms = mArms;
    }

    public String getmFat() {
        return mFat;
    }

    public void setmFat(String mFat) {
        this.mFat = mFat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public MembersGoal getmGoal() {
        return mGoal;
    }

    public void setmGoal(MembersGoal mGoal) {
        this.mGoal = mGoal;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public ClassSchedule getClassTime() {
        return classTime;
    }

    public void setClassTime(ClassSchedule classTime) {
        this.classTime = classTime;
    }

    public String getmStartDate() {
        return mStartDate;
    }

    public void setmStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getmEndDate() {
        return mEndDate;
    }

    public void setmEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }

    public String getmFirstPayment() {
        return mFirstPayment;
    }

    public void setmFirstPayment(String mFirstPayment) {
        this.mFirstPayment = mFirstPayment;
    }
}
