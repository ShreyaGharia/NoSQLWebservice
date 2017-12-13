package com.target.myRetail.service;


import com.target.myRetail.entity.Product;
import com.target.myRetail.remoteApi.ProductRemoteApi;
import com.target.myRetail.remoteApi.ProductRemoteApiTest;
import com.target.myRetail.repository.ProductRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shreya on 12/12/2017.
 */

public class ProductServiceTest {

    @InjectMocks
  ProductService productService;

    @Mock
    ProductRepo productRepo;

    @Mock
    ProductRemoteApi productRemoteApi;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findProductByIdTest() throws Exception{
        Map<String, String> currency = new HashMap<>();
        currency.put("value", "13.49");
        currency.put("currency_code", "USD");
        Product mockProduct = new Product("13860428", "", currency);
        Mockito.when(productRepo.getProductByProductId(Mockito.anyString())).thenReturn(mockProduct);

        Mockito.when(productRemoteApi.getProductById(Mockito.anyString()))
                .thenReturn(new ProductRemoteApiTest().getProductById("13860428"));

        // Actual Result
        Product actualProduct = productService.findProductById("13860428");

        // Expected Result
        Map<String, String> currency1 = new HashMap<>();
        currency.put("value", "13.49");
        currency.put("currency_code", "USD");
        Product expectedProduct = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", currency1);

        assertEquals(expectedProduct.getProductId(), actualProduct.getProductId());
    }


    @Test(expected = NullPointerException.class)
    public void getProductByNotAvailableProductIdTest() throws Exception {

        Map<String, String> currency = new HashMap<>();
        currency.put("value", "13.49");
        currency.put("currency_code", "USD");
        Product mockProduct = new Product("13860428", "", currency);
        Mockito.when(productRepo.getProductByProductId(Mockito.anyString())).thenReturn(mockProduct);
        productService.findProductById("123");
    }
}
