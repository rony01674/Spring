package com.demoproject.repository.attendanceManagement;

import com.demoproject.entity.attendanceManagement.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<ClassEntity, Long> {
}
