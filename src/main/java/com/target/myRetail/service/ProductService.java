package com.target.myRetail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.myRetail.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.target.myRetail.remoteApi.ProductRemoteApi;
import com.target.myRetail.repository.ProductRepo;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Shreya on 12/12/2017.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRemoteApi productRemoteApi;

    @Autowired
    private ProductRepo productRepo;

    public Product findProductById(String productId) throws IOException {
        Product product = productRepo.getProductByProductId(productId);
        // external API
        product.setTitle(this.getTitleByProductId(productId));
        return product;
    }

    public String getTitleByProductId(String productId) throws IOException {
        Map<String, Map> extMap = getProductFromExternalService(productId);

        Map<String,Map> productMap = extMap.get("product");
        Map<String,Map> itemMap = productMap.get("item");
        Map<String,String> productDMap = itemMap.get(("product_description"));

        return productDMap.get("title") ;
    }

    public Map<String, Map> getProductFromExternalService (String productId) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> responseEntity = productRemoteApi.getProductById(productId);
        Map<String, Map> externalMap = objectMapper.readValue(responseEntity.getBody(), Map.class);
        return externalMap;
    }

    public void updateProductByProductId (Product product){
        productRepo.save(product);
    }
}
