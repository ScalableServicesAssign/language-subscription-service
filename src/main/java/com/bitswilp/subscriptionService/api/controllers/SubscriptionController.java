package com.bitswilp.subscriptionService.api.controllers;

import com.bitswilp.subscriptionService.api.dto.SubscriptionDto;
import com.bitswilp.subscriptionService.api.models.Subscription;
import com.bitswilp.subscriptionService.api.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@Tag(name = "Subscription API", description = "Operations related to user subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Operation(summary = "Get all subscriptions", description = "Fetch all subscription records.")
    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @Operation(summary = "Get subscription by ID", description = "Fetch a subscription record by its ID.")
    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @Operation(summary = "Create a new subscription", description = "Create a new subscription for a user.")
    @PostMapping
    public Subscription createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.createSubscription(subscriptionDto);
    }

    @Operation(summary = "Update an existing subscription", description = "Update the status of an existing subscription.")
    @PutMapping("/{id}")
    public Subscription updateSubscription(@PathVariable Long id, @RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.updateSubscription(id, subscriptionDto);
    }

    @Operation(summary = "Delete a subscription", description = "Delete a subscription by its ID.")
    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }
}
