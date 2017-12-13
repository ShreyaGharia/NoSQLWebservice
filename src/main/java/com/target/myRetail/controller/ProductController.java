package com.target.myRetail.controller;

import com.target.myRetail.entity.Product;
import com.target.myRetail.exception.OtherResponse;
import com.target.myRetail.exception.ProductNotFound;
import com.target.myRetail.exception.ProductNotMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.target.myRetail.service.ProductService;

/**
 * Created by Shreya on 12/12/2017.
 */
@RequestMapping(value="/products")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productId) {

        Product product;
        try {
            product = productService.findProductById(productId);
        } catch (Exception e) {
            throw new ProductNotFound();
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<OtherResponse> modifyPrice(@RequestBody Product product,
                                                      @PathVariable("id") String productId) {
        if (!product.productId.equalsIgnoreCase(productId)) {
            throw new ProductNotMatch();
        }
        try {
            productService.updateProductByProductId(product);
        } catch (Exception e) {
            throw new ProductNotFound();
        }

        return new ResponseEntity<OtherResponse>(
                new OtherResponse(HttpStatus.OK.value(), "Product has been updated"), HttpStatus.OK);
    }
}
