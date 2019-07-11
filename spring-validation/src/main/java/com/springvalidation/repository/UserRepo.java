package com.springvalidation.repository;

import com.springvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmailOrAgeAndRound(String email, int age, String round);
}
