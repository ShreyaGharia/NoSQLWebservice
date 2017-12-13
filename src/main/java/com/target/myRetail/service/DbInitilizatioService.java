package com.target.myRetail.service;

import com.target.myRetail.entity.Product;
import com.target.myRetail.entity.Roles;
import com.target.myRetail.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.target.myRetail.repository.ProductRepo;
import com.target.myRetail.repository.RolesRepo;
import com.target.myRetail.repository.UserRepo;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Shreya on 12/12/2017.
 */
@Service
public class DbInitilizatioService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepo rolesRepo;
    @Autowired
    private UserRepo userRepo;

    public DbInitilizatioService(){}
    @PostConstruct
    public void init(){
        addProduct();
        addRole();
    }

    private void addProduct(){
        if (productRepo != null) {
            Map<String, String> currency1 = new HashMap<>();
            currency1.put("value", "13.49");
            currency1.put("currency_code", "USD");
            Product product1 = new Product("13860428", "", currency1);

            Map<String, String> currency2 = new HashMap<>();
            currency2.put("value", "10");
            currency2.put("currency_code", "USD");
            Product product2 = new Product("15117729", "", currency2);

            Map<String, String> currency3 = new HashMap<>();
            currency3.put("value", "43");
            currency3.put("currency_code", "USD");
            Product product3 = new Product("16483589", "", currency3);

            Map<String, String> currency4 = new HashMap<>();
            currency4.put("value", "0.99");
            currency4.put("currency_code", "USD");
            Product product4 = new Product("16696652", "", currency4);

            Map<String, String> currency5 = new HashMap<>();
            currency5.put("value", "99.99");
            currency5.put("currency_code", "USD");
            Product product5 = new Product("16752456", "", currency5);

            Map<String, String> currency6 = new HashMap<>();
            currency6.put("value", "9.99");
            currency6.put("currency_code", "USD");
            Product product6 = new Product("15643793", "", currency6);
            this.productRepo.deleteAll();
            List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6);
            this.productRepo.save(products);
        }
    }

    private void addRole(){
        if(userRepo != null) {
            this.rolesRepo.deleteAll();
            Roles role1 = new Roles("1", "USER");
            rolesRepo.save(role1);

            Roles role2 = new Roles("2", "ADMIN");
            rolesRepo.save(role2);

            List<Roles> roles3 = new ArrayList<>();
            roles3.add(role1);
            roles3.add(role2);

            List<User> accounts = new ArrayList<>();

            User account1 = new User("1", "admin", passwordEncoder.encode("admin"), roles3);
            accounts.add(account1);

            User account2 = new User("2", "user", passwordEncoder.encode("user"), roles3);
            accounts.add(account2);
            this.userRepo.deleteAll();
            this.userRepo.save(accounts);
        }
    }
}
