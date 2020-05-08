package com.example.springcontinue.repository;

import com.example.springcontinue.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer> {
    ApplicationUserRepository findByUsername(String username);
}
