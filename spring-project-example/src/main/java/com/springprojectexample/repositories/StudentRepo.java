package com.springprojectexample.repositories;

import com.springprojectexample.entity.Department;
import com.springprojectexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Iterable<Student> findAllByDepartment(Department department);

    //finding a list by department and gender
    Iterable<Student> findAllByDepartmentAndGender(Department department, String gender);

    //finding all number of student by department and gender
    long countAllByDepartmentAndGender(Department department, String gender);

    Iterable<Student> findAllByAgeGreaterThanEqual(int age);

    Iterable<Student> findAllByDepartmentOrderByDepartmentDesc(Department department);
}
