package com.example.rulebasedrouteoptimization.repository;


import com.example.rulebasedrouteoptimization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User,Integer> {
  //  Optional<User> findUsersByEmail(String email);

    Optional<User> findUsersByEmailAndPassword(String email,String password);
    User findUsersByEmail(String email);
    @Query("SELECT COUNT(u) FROM User u WHERE u.role = 'outletuser'")
    Integer branchCount();
}