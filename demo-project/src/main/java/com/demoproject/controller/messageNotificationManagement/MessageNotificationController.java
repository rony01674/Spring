package com.demoproject.controller.messageNotificationManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageNotificationController {

    @GetMapping(value = "/compose-message")
    public String displayMsg(){
        return "message-notification-management/compose-message";
    }
}
