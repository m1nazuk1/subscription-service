package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.entity.User;
import com.example.subscriptionservice.entity.Subscription;
import com.example.subscriptionservice.service.UserService;
import com.example.subscriptionservice.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSenderService messageSenderService;
    @PostMapping
    public User createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        messageSenderService.sendMessage("subscription-service", "User created: " + created.getId());
        return created;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User updated = userService.updateUser(id, user);
        messageSenderService.sendMessage("subscription-service", "User updated: " + id);
        return updated;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        messageSenderService.sendMessage("subscription-service", "User deleted: " + id);
    }
    @PostMapping("/{id}/subscriptions")
    public Subscription addSubscription(@PathVariable Long id, @RequestBody Subscription sub) {
        Subscription created = userService.addSubscription(id, sub.getServiceName());
        messageSenderService.sendMessage("subscription-service", "Subscription added: " + created.getServiceName());
        return created;
    }
    @GetMapping("/{id}/subscriptions")
    public List<Subscription> getSubscriptions(@PathVariable Long id) {
        return userService.getSubscriptions(id);
    }
    @DeleteMapping("/{id}/subscriptions/{subId}")
    public void deleteSubscription(@PathVariable Long id, @PathVariable Long subId) {
        userService.deleteSubscription(subId);
        messageSenderService.sendMessage("subscription-service", "Subscription deleted: " + subId);
    }
}
