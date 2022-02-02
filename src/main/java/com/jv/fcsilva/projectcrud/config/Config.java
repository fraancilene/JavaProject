package com.jv.fcsilva.projectcrud.config;

import com.jv.fcsilva.projectcrud.entity.Category;
import com.jv.fcsilva.projectcrud.entity.Order;
import com.jv.fcsilva.projectcrud.entity.Product;
import com.jv.fcsilva.projectcrud.entity.User;
import com.jv.fcsilva.projectcrud.entity.enums.OrderStatus;
import com.jv.fcsilva.projectcrud.repository.CategoryRepository;
import com.jv.fcsilva.projectcrud.repository.OrderRepository;
import com.jv.fcsilva.projectcrud.repository.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;



    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Maria", "maria@gmail.com", "9888521", "123456");
        User u2 = new User(null, "Anne", "anne@gmail.com", "9877521", "125456");

        Order o1 = new Order(null,Instant.parse("2022-01-20T13:54:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-01-20T13:54:07Z"),OrderStatus.WAITTING_PAYMENT, u2);
        Order o3 = new Order(null,Instant.parse("2022-01-20T13:54:07Z"), OrderStatus.WAITTING_PAYMENT, u1);

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5, "");
        Product p2 = new Product(null,"Smart TV","Nulle eu imperdiet. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null,"Macbook Pro", "Lorem ipsum dolor sit amet, consectetur", 1250.0, "");
        Product p4 = new Product(null,"PC Gamer", "Nulle eu imperdiet. Maecenas ante.", 1200.0, "");
        Product p5 = new Product(null,"Rails for Dumies", "Lorem ipsum dolor sit amet, consectetur", 100.99, "");



        // salvando no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // associando os produtos as suas categorias
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        // salvando as associações
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));



    }
}
