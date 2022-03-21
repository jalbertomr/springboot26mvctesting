package com.bext.testing.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage() {
        return "from Service - this Message.";
    }
}
