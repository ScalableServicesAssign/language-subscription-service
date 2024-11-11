package com.bitswilp.subscriptionService.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;  // Using email as the username field

    private String password;

    private String subscriptionStatus;  // Status such as "ACTIVE", "INACTIVE", etc.

    // Constructors
    public User() {}

    public User(String name, String email, String password, String subscriptionStatus) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscriptionStatus = subscriptionStatus;
    }

    // Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    // UserDetails interface methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();  // Return empty list if no roles/authorities
    }

    @Override
    public String getUsername() {
        return email;  // Email is used as the username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Account is non-expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Account is non-locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Credentials are non-expired
    }

    @Override
    public boolean isEnabled() {
        return "ACTIVE".equals(subscriptionStatus);  // Only enable if subscription status is "ACTIVE"
    }
}
