package com.demoproject.entity.memberManagement;

import com.demoproject.entity.mebershipTypeManagement.MembersGoal;
import com.demoproject.entity.attendanceManagement.ClassSchedule;
import com.demoproject.entity.mebershipTypeManagement.MembershipType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mId;

    @NotEmpty
    private String mName;
    @NotEmpty
    private String mFatherName;
    @NotEmpty
    private String mGender;
    @NotEmpty
    private String mBirthday;
    @NotEmpty
    private String mAddress;
    @NotEmpty
    private String mCity;
    @NotEmpty
    private String mZipCode;
    @NotEmpty
    @Column(unique = true)
    private String mMobileNo;
    @NotEmpty
    @Column(unique = true)
    private String mEmail;
    private int mWeight;
    private String mHeight;
    private int mChest;
    private int mWaist;
    private int mThigh;
    private int mArms;
    private String mFat;
    @NotEmpty
    @Column(unique = true)
    private String mUserName;
    @NotEmpty
    private String mPassword;

    //For image upload
    private long fileSize;
    private String fileName;
    @Lob
    private byte[] file;
    private String filePath;
    private String fileExtension;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "members_goal_id", referencedColumnName = "id")
    private MembersGoal mGoal;
    private String mType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "m_type_id", referencedColumnName = "membership_type_id")
    private MembershipType membershipType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_time_id", referencedColumnName = "class_id")
    private ClassSchedule classTime;
    @NotEmpty
    private String mStartDate;
    @NotEmpty
    private String mEndDate;
    @NotEmpty
    private String mFirstPayment;


    public Member() {
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
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

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
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
