package com.target.myRetail.controller;

import com.target.myRetail.entity.Product;
import com.target.myRetail.exception.ProductNotFound;
import com.target.myRetail.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shreya on 12/12/2017.
 */
@WebMvcTest(value = ProductController.class)
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductTest() throws Exception{
        Map<String, String> currency = new HashMap<>();
        currency.put("id", "13.49");
        currency.put("Currency_code", "USD");
        Product productMock = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", currency);

        Mockito.when(productService.findProductById(Mockito.anyString())).thenReturn(productMock);

        String url = "/products/13860428";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedProductJson = "{\"productId\": \"13860428\",\"title\": \"The Big Lebowski (Blu-ray) (Widescreen\",\"current_price\": {\"value\": \"13.49\",\"currency_code\": \"USD\"}}";

        JSONAssert.assertEquals(expectedProductJson, result.getResponse().getContentAsString(), false);

    }

    @Test
    public void getProductInfoTest_wrongProductId() throws Exception {
        Mockito.when(productService.findProductById(Mockito.anyString())).thenThrow(new NullPointerException());

        try {
            String url = "/products/123";
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
            mockMvc.perform(requestBuilder).andReturn();
        } catch (ProductNotFound e) {
        }
    }

}
