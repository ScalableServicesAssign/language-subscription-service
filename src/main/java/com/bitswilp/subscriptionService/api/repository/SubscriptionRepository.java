package com.bitswilp.subscriptionService.api.repository;

import com.bitswilp.subscriptionService.api.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
