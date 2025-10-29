package com.docme360.docme360_sample_api.rest;

import org.json.simple.JSONObject;
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
        Double a  = calculator.getA();
        Double b = calculator.getB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%.2f - %.2f",a,b));
        jsonObject.put("output", a - b);
        return jsonObject;
    }

    @GetMapping("/multiply")
    public JSONObject multiply(@RequestParam Double a, @RequestParam Double b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%d * %d",a,b));
        jsonObject.put("output", a * b);
        return jsonObject;
    }

    @GetMapping("/divide")
    public JSONObject divide(@RequestParam Double numerator, @RequestParam Double denominator) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%d / %d",numerator,denominator));
        if ( denominator == 0 ) {
            jsonObject.put("output", "Undefined");
        } else {
            jsonObject.put("output", numerator * denominator);
        }
        return jsonObject;
    }
}
