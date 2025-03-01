package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private UserService userService;
    @GetMapping("/top")
    public List<String> getTopSubscriptions() {
        return userService.getTopSubscriptions();
    }
}
