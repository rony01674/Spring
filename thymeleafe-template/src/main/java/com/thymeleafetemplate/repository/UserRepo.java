package com.thymeleafetemplate.repository;

import com.thymeleafetemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findAllByEmail(String email);

    //User findByMobileAnd(String mobile);

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserNameOrEmail(String userName, String email);

}
