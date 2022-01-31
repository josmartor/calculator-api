package com.example.calculator.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CalculatorException extends  RuntimeException {

    String message;

}
