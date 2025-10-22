package com.docme360.docme360_sample_api.rest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v0")
public class hackathonRestController {
    @GetMapping("/hello")
    public JSONObject hello(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "hello DOCME360 hackathon");
        return jsonObject;
    }

}
