package com.example.calculator.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.Operation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    public BigDecimal calculate(Operation operation) {
        List<BigDecimal> operands = operation.getOperands();
        switch (operation.getType())
        {
            case ADD:
                return operands.get(0).add(operands.get(1));
            case SUBTRACT:
                return operands.get(0).subtract(operands.get(1));
            default:
                return BigDecimal.ZERO;
        }
    }
}