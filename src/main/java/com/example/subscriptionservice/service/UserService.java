package com.example.subscriptionservice.service;

import com.example.subscriptionservice.entity.User;
import com.example.subscriptionservice.entity.Subscription;
import com.example.subscriptionservice.repository.UserRepository;
import com.example.subscriptionservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(Long id, User data) {
        User u = userRepository.findById(id).orElse(null);
        if(u!=null) {
            u.setName(data.getName());
            u.setEmail(data.getEmail());
            return userRepository.save(u);
        }
        return null;
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public Subscription addSubscription(Long userId, String serviceName) {
        Subscription s = new Subscription();
        s.setUserId(userId);
        s.setServiceName(serviceName);
        return subscriptionRepository.save(s);
    }
    public List<Subscription> getSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }
    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }
    public List<String> getTopSubscriptions() {
        return subscriptionRepository.findTop3ByPopularity();
    }
}
