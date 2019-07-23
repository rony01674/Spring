package com.project.entity.membershipType;

import com.project.entity.ClassTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

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
    private double membershipAmount;

    @NotEmpty(message = "Select your workout time")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "membership_type_class_time",
            joinColumns = @JoinColumn(name = "membership_type_id"),
            inverseJoinColumns = @JoinColumn(name = "class_time_id")
    )
    private Set<ClassTime> selectClass;

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

    public double getMembershipAmount() {
        return membershipAmount;
    }

    public void setMembershipAmount(double membershipAmount) {
        this.membershipAmount = membershipAmount;
    }

    public Set<ClassTime> getSelectClass() {
        return selectClass;
    }

    public void setSelectClass(Set<ClassTime> selectClass) {
        this.selectClass = selectClass;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }
}
