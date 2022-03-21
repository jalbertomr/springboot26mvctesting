package com.bext.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class OnlyWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerResponseShouldRespond() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo( print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("HomeController respond this")));
    }
}
