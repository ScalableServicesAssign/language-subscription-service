package com.bitswilp.subscriptionService.api.service;

import com.bitswilp.subscriptionService.api.dto.SubscriptionDto;
import com.bitswilp.subscriptionService.api.models.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription getSubscriptionById(Long id);
    Subscription createSubscription(SubscriptionDto subscriptionDto);
    List<Subscription> getAllSubscriptions();
    Subscription updateSubscription(Long id, SubscriptionDto subscriptionDto);
    void deleteSubscription(Long id);
}
