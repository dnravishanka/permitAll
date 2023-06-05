package com.example.springboot2.db;

import com.example.springboot2.model.Users;
import com.example.springboot2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public DbInit(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //create users
        Users nadun = new Users("nadun", passwordEncoder.encode("nadun123"), "ROLE_USERS", "");
        Users manager = new Users("manager", passwordEncoder.encode("manager123"), "ROLE_MANAGER", "ACCESS_NAME,ACCESS_ADDRESS");
        Users admin = new Users("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN", "ACCESS_NAME,ACCESS_ALL,ACCESS_ADDRESS");
        List<Users> users = Arrays.asList(nadun, manager, admin);

        //without if condition, when we restart the server(app) -->new users are added to users table every time(same users in
        // in different id s
        List<Users> all = userRepository.findAll();
        if (all.isEmpty()) {
            //save in database
            this.userRepository.saveAll(users);
        }





    }
}
