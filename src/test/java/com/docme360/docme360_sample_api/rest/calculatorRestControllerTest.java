package com.docme360.docme360_sample_api.rest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.springframework.http.MediaType;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CalculatorRestController.class)
class calculatorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;

    @Test
    void add() throws Exception  {
        mockMvc.perform(get("/calculator/add")
                .param("a", "3")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.output").value("5"));
    }

}