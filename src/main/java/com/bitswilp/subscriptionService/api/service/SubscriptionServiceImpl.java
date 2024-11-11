package com.bitswilp.subscriptionService.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitswilp.subscriptionService.api.dto.SubscriptionDto;
import com.bitswilp.subscriptionService.api.models.Subscription;
import com.bitswilp.subscriptionService.api.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        return subscription.orElseThrow(() -> new RuntimeException("Subscription not found for id: " + id));
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

    @Override
    public Subscription updateSubscription(Long id, SubscriptionDto subscriptionDto) {
        Subscription subscription = getSubscriptionById(id);  // fetch existing subscription
        subscription.setUserId(subscriptionDto.getUserId());
        subscription.setSubscriptionType(subscriptionDto.getSubscriptionType());
        subscription.setStatus(subscriptionDto.getStatus());

        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        Subscription subscription = getSubscriptionById(id);
        subscriptionRepository.delete(subscription);
    }
}
