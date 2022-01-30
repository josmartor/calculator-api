package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CalculatorApi;
import org.openapitools.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CalculatorController implements CalculatorApi {

    @Autowired
    CalculatorService calculatorService;

    @Override
    public ResponseEntity<BigDecimal> performOperation(@Valid Operation operation) {
        BigDecimal result = calculatorService.calculate(operation);
        return ResponseEntity.ok(result);
    }
}