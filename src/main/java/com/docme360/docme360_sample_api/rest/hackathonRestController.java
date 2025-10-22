package com.docme360.docme360_sample_api.rest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hackathonRestController {
    @GetMapping("/")
    public JSONObject home(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "hello DOCME360 hackathon");
        return jsonObject;
    }

}
