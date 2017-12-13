package com.target.myRetail.repository;

import com.target.myRetail.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Shreya on 12/12/2017.
 */
public interface UserRepo extends MongoRepository<User, String > {
    public User findByUsername(String username);
}
