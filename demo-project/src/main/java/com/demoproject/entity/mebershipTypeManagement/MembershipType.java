package com.demoproject.entity.mebershipTypeManagement;

import com.demoproject.entity.attendanceManagement.ClassSchedule;

import javax.persistence.*;

@Entity
public class MembershipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_type_id")
    private Long membershipTypeId;

    @Column(unique = true)
    private String membershipName;
    private String membershipDays;
    private double membershipAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private ClassSchedule classTime;
    private double regFee;

//    //For image upload
//    private long fileSize;
//    private String fileName;
//    @Lob
//    private byte[] file;
//    private String filePath;
//    private String fileExtension;

    public MembershipType() {
    }

    public Long getMembershipTypeId() {
        return membershipTypeId;
    }

    public void setMembershipTypeId(Long membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public String getMembershipDays() {
        return membershipDays;
    }

    public void setMembershipDays(String membershipDays) {
        this.membershipDays = membershipDays;
    }

    public double getMembershipAmount() {
        return membershipAmount;
    }

    public void setMembershipAmount(double membershipAmount) {
        this.membershipAmount = membershipAmount;
    }

    public ClassSchedule getClassTime() {
        return classTime;
    }

    public void setClassTime(ClassSchedule classTime) {
        this.classTime = classTime;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

//    public long getFileSize() {
//        return fileSize;
//    }
//
//    public void setFileSize(long fileSize) {
//        this.fileSize = fileSize;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public byte[] getFile() {
//        return file;
//    }
//
//    public void setFile(byte[] file) {
//        this.file = file;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public String getFileExtension() {
//        return fileExtension;
//    }
//
//    public void setFileExtension(String fileExtension) {
//        this.fileExtension = fileExtension;
//    }
}
