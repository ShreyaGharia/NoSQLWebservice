package com.target.myRetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Shreya on 12/12/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No product found ")
public class ProductNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductNotFound() {

    }
}

