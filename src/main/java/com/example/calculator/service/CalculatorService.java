package com.example.calculator.service;

import com.example.calculator.error.CalculatorException;
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
                return add(operands);
            case SUBTRACT:
                return subtract(operands);
            default:
                throw new CalculatorException("Operation not supported");
        }
    }

    private BigDecimal add(List<BigDecimal> operands) {
        checkOperands(operands);
        return operands.get(0).add(operands.get(1));
    }

    private BigDecimal subtract(List<BigDecimal> operands) {
        checkOperands(operands);
        return operands.get(0).subtract(operands.get(1));
    }

    private void checkOperands(List<BigDecimal> operands) {
        if (operands.size() != 2) {
            throw new CalculatorException("Wrong number of operands, only two operands are allowed");
        }
    }
}