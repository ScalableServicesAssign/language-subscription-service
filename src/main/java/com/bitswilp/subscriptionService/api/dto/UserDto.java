package com.bitswilp.subscriptionService.api.dto;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String subscriptionStatus;

    // Constructors
    public UserDto() {}

    public UserDto(Long id, String name, String email, String subscriptionStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

	public String getUsername() {
		return email;
	}
}
