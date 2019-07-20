package com.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class MembershipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    @NotEmpty(message = "Enter membership name")
    @Column(unique = true)
    private String membershipName;

    @NotEmpty(message = "Enter membership days")
    private String membershipPeriod;

    @NotEmpty(message = "Enter amount")
    private double membershipAmmount;

    @NotEmpty(message = "Select your workout time")
    private String selectClass;

    @NotEmpty(message = "Enter registration fee")
    private double regFee;

    public MembershipType() {
    }

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public String getMembershipPeriod() {
        return membershipPeriod;
    }

    public void setMembershipPeriod(String membershipPeriod) {
        this.membershipPeriod = membershipPeriod;
    }

    public double getMembershipAmmount() {
        return membershipAmmount;
    }

    public void setMembershipAmmount(double membershipAmmount) {
        this.membershipAmmount = membershipAmmount;
    }

    public String getSelectClass() {
        return selectClass;
    }

    public void setSelectClass(String selectClass) {
        this.selectClass = selectClass;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }
}
