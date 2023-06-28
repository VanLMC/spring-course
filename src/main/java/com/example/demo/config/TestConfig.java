package com.example.demo.config;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), u1);


        userRepository.saveAll(List.of(u1,u2));
        orderRepository.saveAll(List.of(o1, o2, o3));

    }
}
