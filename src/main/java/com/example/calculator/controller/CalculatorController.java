package com.example.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.CalculatorApi;
import org.openapitools.model.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CalculatorController implements CalculatorApi {

    @Override
    public ResponseEntity<BigDecimal> performOperation(@Valid Operation operation) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}