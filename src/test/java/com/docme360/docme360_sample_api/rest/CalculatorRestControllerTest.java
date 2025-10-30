package com.docme360.docme360_sample_api.rest;
import com.docme360.docme360_sample_api.entity.CalculatorInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

@WebMvcTest(CalculatorRestController.class)
class CalculatorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Adding 3 + 2 should be 5")
    void add() throws Exception  {
        mockMvc.perform(get("/calculator/add")
                .param("a", "3")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.output").value("5"));
    }

    @Test
    @DisplayName("Subtract  10.0 - 3.0 should be 7.0")
    void subtract() throws Exception  {
        CalculatorInput calculatorInput = new CalculatorInput(10.0,3.0);
        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = mapper.writeValueAsString(calculatorInput);
        mockMvc.perform(post("/calculator/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output").value(7.0));

    }

    @Test
    @DisplayName("Multiply  10.0 * 3.0 should be 30.0")
    void multiply() throws Exception  {
        CalculatorInput calculatorInput = new CalculatorInput(10.0,3.0);
        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = mapper.writeValueAsString(calculatorInput);
        mockMvc.perform(post("/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output").value(30.0));

    }

    @Test
    @DisplayName("Divide  10.0 / 2.0 should be 5.0")
    void divide() throws Exception  {
        CalculatorInput calculatorInput = new CalculatorInput(10.0,2.0);
        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = mapper.writeValueAsString(calculatorInput);
        mockMvc.perform(post("/calculator/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output").value(5.0));

    }

    @Test
    @DisplayName("Divide  10.0 / 0 should be error 'Cannot divide by zero.' ")
    void divideByZero() throws Exception  {
        CalculatorInput calculatorInput = new CalculatorInput(10.0, 0.0);
        String errorMessage = "Cannot divide by zero.";
        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = mapper.writeValueAsString(calculatorInput);
        mockMvc.perform(post("/calculator/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessage").value(errorMessage));

    }

}