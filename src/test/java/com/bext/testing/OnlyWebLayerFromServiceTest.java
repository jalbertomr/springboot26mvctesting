package com.bext.testing;

import com.bext.testing.controller.MessageController;
import com.bext.testing.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageController.class)
public class OnlyWebLayerFromServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @Test
    public void controllerResponseShouldRespond() throws Exception {
        when(messageService.getMessage()).thenReturn("from Mocked Service - this Message.");

        this.mockMvc.perform(get("/message"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("from Mocked Service - this Message.")));
    }
}
