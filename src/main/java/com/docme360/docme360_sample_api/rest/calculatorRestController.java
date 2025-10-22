package com.docme360.docme360_sample_api.rest;


import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class calculatorRestController {
    @GetMapping("/add")
    public JSONObject add(@RequestParam Integer a, @RequestParam Integer b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%d + %d",a,b));
        jsonObject.put("output", a + b);
        return jsonObject;
    }

    @GetMapping("/subtract")
    public JSONObject subtract(@RequestParam Double a, @RequestParam Double b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", String.format("%d - %d",a,b));
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
}
