package com.target.myRetail.repository;

import com.target.myRetail.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Shreya on 12/12/2017.
 */
public interface ProductRepo extends MongoRepository<Product, String> {
    public Product getProductByProductId( String productId);
}
