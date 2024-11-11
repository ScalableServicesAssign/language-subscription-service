package com.bitswilp.subscriptionService.api.service;

import com.bitswilp.subscriptionService.api.dto.SubscriptionDto;
import com.bitswilp.subscriptionService.api.models.Subscription;
import com.bitswilp.subscriptionService.api.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    @Override
    public Subscription createSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();
        subscription.setUserId(subscriptionDto.getUserId());
        subscription.setSubscriptionType(subscriptionDto.getSubscriptionType());
        subscription.setStatus(subscriptionDto.getStatus());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
