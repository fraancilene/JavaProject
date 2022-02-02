package com.jv.fcsilva.projectcrud.config;

import com.jv.fcsilva.projectcrud.entity.*;
import com.jv.fcsilva.projectcrud.entity.enums.OrderStatus;
import com.jv.fcsilva.projectcrud.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;



    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        User user1 = new User(null, "Maria", "maria@gmail.com", "9888521", "123456");
        User user2 = new User(null, "Anne", "anne@gmail.com", "9877521", "125456");

        Order order1 = new Order(null,Instant.parse("2022-01-20T13:54:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2022-01-20T13:54:07Z"),OrderStatus.WAITTING_PAYMENT, user2);
        Order order3 = new Order(null,Instant.parse("2022-01-20T13:54:07Z"), OrderStatus.WAITTING_PAYMENT, user1);

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5, "");
        Product product2 = new Product(null,"Smart TV","Nulle eu imperdiet. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null,"Macbook Pro", "Lorem ipsum dolor sit amet, consectetur", 1250.0, "");
        Product product4 = new Product(null,"PC Gamer", "Nulle eu imperdiet. Maecenas ante.", 1200.0, "");
        Product product5 = new Product(null,"Rails for Dumies", "Lorem ipsum dolor sit amet, consectetur", 100.99, "");

        OrderItem oi1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem oi2 = new OrderItem(order1, product3, 2, product4.getPrice());
        OrderItem oi3 = new OrderItem(order2, product3, 2, product1.getPrice());
        OrderItem oi4 = new OrderItem(order3, product5, 2, product5.getPrice());



        // salvando no banco de dados
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        // associando os produtos as suas categorias
        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        // salvando as associações
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        // salvando os dados do orderitem
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));



    }
}
