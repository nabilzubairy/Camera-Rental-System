package com.zubairy.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubairy.crs.dao.CartDao;
import com.zubairy.crs.model.Cart;

import jakarta.transaction.Transactional;

@Service
public class CartService {
	
	@Autowired
	CartDao dao;

	public List<Cart> getCart(Long userId) {
		return dao.findByUserId(userId);
	}

	public Cart addToCart(int userId, Long cameraId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setCameraId(cameraId);
		return dao.save(cart);
	}

	@Transactional
	public void clearCart(int userId) {
		dao.deleteByUserId(userId);
		
	}
	

}
