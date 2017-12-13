package com.target.myRetail.remoteApi;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Shreya on 12/12/2017.
 */
@FeignClient(
        name = "External-Api",
        url = "http://redsky.target.com/v1/pdp/tcin/"
)
public interface ProductRemoteApi {
    @RequestMapping(method = RequestMethod.GET, value = "{productId}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics")
    public ResponseEntity<String> getProductById(@PathVariable("productId") String productId);
}

