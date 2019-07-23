package com.project.entity.memberWorkoutReport;

import com.project.entity.memberManagement.GymMembers;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class BodyMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne
    @JoinColumn(name = "gym_member_id")
    private Set<GymMembers> gymMembers;

    public BodyMeasurement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<GymMembers> getGymMembers() {
        return gymMembers;
    }

    public void setGymMembers(Set<GymMembers> gymMembers) {
        this.gymMembers = gymMembers;
    }
}
