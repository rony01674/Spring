package com.demoproject.repository.attendanceManagement;

import com.demoproject.entity.attendanceManagement.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassScheduleRepo extends JpaRepository<ClassSchedule, Long> {
}
