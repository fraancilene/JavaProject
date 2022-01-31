package com.jv.fcsilva.projectcrud.config;

import com.jv.fcsilva.projectcrud.entity.Order;
import com.jv.fcsilva.projectcrud.entity.User;
import com.jv.fcsilva.projectcrud.entity.enums.OrderStatus;
import com.jv.fcsilva.projectcrud.repository.OrderRepository;
import com.jv.fcsilva.projectcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
//@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "9888521", "123456");
        User u2 = new User(null, "Anne", "anne@gmail.com", "9877521", "125456");
        //User u3 = new User(null, "Joana", "anne@gmail.com", "9877521", "125456");

        Order o1 = new Order(null,Instant.parse("2022-01-20T13:54:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-01-20T13:54:07Z"),OrderStatus.WAITTING_PAYMENT, u2);
        Order o3 = new Order(null,Instant.parse("2022-01-20T13:54:07Z"), OrderStatus.WAITTING_PAYMENT, u1);

        // salvando no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
