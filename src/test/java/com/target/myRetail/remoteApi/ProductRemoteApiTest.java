package com.target.myRetail.remoteApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Shreya on 12/12/2017.
 */
public class ProductRemoteApiTest implements ProductRemoteApi {

    public ResponseEntity<String> getProductById(String productId) {
        String productInfo = "{\"product\": {\"item\": {\"product_description\": {\"title\": \"The Big Lebowski (Blu-ray) (Widescreen)\"}}}}";

        return new ResponseEntity<String>(productInfo, HttpStatus.OK);

    }
}
