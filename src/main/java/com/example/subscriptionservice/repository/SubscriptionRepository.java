package com.example.subscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.subscriptionservice.entity.Subscription;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);
    @Query("select s.serviceName from Subscription s group by s.serviceName order by count(s.serviceName) desc limit 3")
    List<String> findTop3ByPopularity();
}
