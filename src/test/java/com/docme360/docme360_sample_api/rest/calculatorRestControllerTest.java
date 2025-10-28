package com.docme360.docme360_sample_api.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CalculatorRestController.class)
class calculatorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void add() throws Exception  {
        mockMvc.perform(get("/calculator/add")
                .param("a", "3")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void subtract() throws Exception  {
        CalculatorInput calculatorInput = new CalculatorInput();
        Double a = 10.0;
        Double b = 3.0;
        mockMvc.perform(post("/calculator/subtract")
                        .param("a", String.valueOf(10.00))
                        .param("b", String.valueOf(2.00)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
    /*
    @Test
    void multiply() throws Exception  {
        mockMvc.perform(get("/calculator/multiply")
                        .param("a", "30.0")
                        .param("b", "2.0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void divide() throws Exception  {
        mockMvc.perform(get("/calculator/divide")
                        .param("numerator", "30.0")
                        .param("denominator", "0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }*/
}