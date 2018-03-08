package com.library.notifications.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @PostMapping(path = "/notifications")
    public void sendNotification(){
        System.out.println("Sending notification.");
    }

}
