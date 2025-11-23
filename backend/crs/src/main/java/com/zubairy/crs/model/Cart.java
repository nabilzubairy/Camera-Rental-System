package com.zubairy.crs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;
    private Long cameraId;

    public Cart() {
	}

	public Cart(Long id, int userId, Long cameraId) {
		super();
		this.id = id;
		this.userId = userId;
		this.cameraId = cameraId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Long getCameraId() {
		return cameraId;
	}

	public void setCameraId(Long cameraId) {
		this.cameraId = cameraId;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", cameraId=" + cameraId + "]";
	}
    
    
}
