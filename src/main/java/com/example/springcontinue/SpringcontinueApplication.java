package com.example.springcontinue;

import com.example.springcontinue.entity.ApplicationUser;
import com.example.springcontinue.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringcontinueApplication {

    @Autowired
    private ApplicationUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostConstruct
    public void addUser() {
        if (userRepository.findByUsername("hasan") == null) {
            String pass = passwordEncoder.encode("123456");
            ApplicationUser user = new ApplicationUser(1, "hasan", pass);
            userRepository.save(user);
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringcontinueApplication.class, args);
    }

}
