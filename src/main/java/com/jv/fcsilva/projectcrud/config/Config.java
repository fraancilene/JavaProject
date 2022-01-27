package com.jv.fcsilva.projectcrud.config;

import com.jv.fcsilva.projectcrud.entity.User;
import com.jv.fcsilva.projectcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "9888521", "123456" );
        User u2 = new User(null, "Anne", "anne@gmail.com", "9877521", "125456" );

        // salvando no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));

    }
}
