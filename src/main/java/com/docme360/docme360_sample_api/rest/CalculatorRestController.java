package com.docme360.docme360_sample_api.rest;

import com.docme360.docme360_sample_api.entity.CalculatorInput;
import com.docme360.docme360_sample_api.entity.CalculatorResponse;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorRestController {
    @GetMapping("/add")
    public JSONObject add(@RequestParam Integer a, @RequestParam Integer b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%d + %d",a,b));
        jsonObject.put("output", a + b);
        return jsonObject;
    }

    @PostMapping("/subtract")
    public JSONObject subtract(@RequestBody CalculatorInput calculator) {
        Double a  = calculator.getFirstNumber();
        Double b = calculator.getSecondNumber();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%.2f - %.2f",a,b));
        jsonObject.put("output", a - b);
        return jsonObject;
    }

    @PostMapping("/multiply")
    public JSONObject multiply(@RequestBody CalculatorInput calculator) {
        Double a  = calculator.getFirstNumber();
        Double b = calculator.getSecondNumber();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%.2f - %.2f",a,b));
        jsonObject.put("output", a * b);
        return jsonObject;
    }

    @GetMapping("/divide")
    public ResponseEntity<CalculatorResponse> divide(@RequestParam Double numerator, @RequestParam Double denominator) {
        String input = String.format("%.2f / %.2f", numerator, denominator);
        String errorMessage = "Cannot divide by zero.";
        try {
            CalculatorResponse calculatorResponse = new CalculatorResponse();
            calculatorResponse.setInput(input);
            if (denominator == 0) {
                throw new IllegalArgumentException(errorMessage);
            }
            calculatorResponse.setOutput(numerator / denominator);
            return new ResponseEntity<>(calculatorResponse, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            CalculatorResponse calculatorResponse = new CalculatorResponse();
            calculatorResponse.setInput(input);
            calculatorResponse.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(calculatorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}