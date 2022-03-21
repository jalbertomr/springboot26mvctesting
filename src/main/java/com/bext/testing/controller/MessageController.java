package com.bext.testing.controller;


import com.bext.testing.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/message")
    @ResponseBody
    public String getMessage(){
        return messageService.getMessage();
    }
}
