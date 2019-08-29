package com.demoproject.entity.attendanceManagement;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class ClassSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @NotEmpty(message = "Enter Class name")
    @Column(unique = true)
    private String className;

    @NotEmpty(message = "Enter Class time")
    @Column(unique = true)
    private String classTime;

    public ClassSchedule() {
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
}
