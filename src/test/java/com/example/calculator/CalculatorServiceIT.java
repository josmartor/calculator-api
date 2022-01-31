package com.example.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorServiceIT {

    private static final String CALCULATOR_PATH = "/calculator/operate/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenAdd() throws Exception {
        MvcResult result = this.mockMvc.perform(post(CALCULATOR_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"add\", \"operands\":[2.0,3.0]}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        Assert.assertEquals(result.getResponse().getContentAsString(), "5.0");

        result = this.mockMvc.perform(post(CALCULATOR_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"add\", \"operands\":[2.00213210320132,3.95524432787253]}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        Assert.assertEquals(result.getResponse().getContentAsString(), "5.95737643107385");
    }

    @Test
    public void whenSubtract() throws Exception {
        MvcResult result = this.mockMvc.perform(post(CALCULATOR_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":\"subtract\", \"operands\":[2.0,3.0]}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        Assert.assertEquals(result.getResponse().getContentAsString(), "-1.0");

        result = this.mockMvc.perform(post(CALCULATOR_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"subtract\", \"operands\":[2.00213210320132,3.95524432787253]}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        Assert.assertEquals(result.getResponse().getContentAsString(), "-1.95311222467121");
    }

    @Test
    public void whenPostAndEmptyRequestBody() throws Exception {
        this.mockMvc.perform(post(CALCULATOR_PATH)).andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void whenGet_thenStatusIsMethodNotAllowed() throws Exception {
        this.mockMvc.perform(get(CALCULATOR_PATH)).andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void whenPut_thenStatusIsMethodNotAllowed() throws Exception {
        this.mockMvc.perform(put(CALCULATOR_PATH)).andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void whenDelete_thenStatusIsMethodNotAllowed() throws Exception {
        this.mockMvc.perform(delete(CALCULATOR_PATH)).andExpect(status().isMethodNotAllowed());
    }
}
