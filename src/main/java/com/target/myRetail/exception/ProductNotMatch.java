package com.target.myRetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Shreya on 12/12/2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product Id doesnot exist .")
public class ProductNotMatch extends RuntimeException {
    public ProductNotMatch(){}
}
