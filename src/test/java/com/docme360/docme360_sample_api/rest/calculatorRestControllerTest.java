package com.docme360.docme360_sample_api.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
                .andExpect(status().isOk());
    }

    @Test
    void subtract() throws Exception  {
        mockMvc.perform(get("/calculator/subtract")
                        .param("a", "3")
                        .param("b", "2"))
                .andExpect(status().isOk());
    }

    @Test
    void multiply() throws Exception  {
        mockMvc.perform(get("/calculator/multiply")
                        .param("a", "3")
                        .param("b", "2"))
                .andExpect(status().isOk());
    }

    @Test
    void divide() throws Exception  {
        mockMvc.perform(get("/calculator/divide")
                        .param("numerator", "3")
                        .param("denominator", "0"))
                .andExpect(status().isOk());
    }
}