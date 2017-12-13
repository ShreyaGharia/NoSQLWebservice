package com.target.myRetail.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Created by Shreya on 12/12/2017.
 */
@Document(collection = "products")
public class Product {
    @Id
    public String productId;
    @org.springframework.data.annotation.Transient
    private String title;
    private Map<String, String> price;
    public Product(){}

    public Product(String productId, String title, Map<String, String> price ){
        this.productId = productId;
        this.title = title;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, String> getPrice() {
        return price;
    }

    public void setPrice(Map<String, String> price) {
        this.price = price;
    }
}
