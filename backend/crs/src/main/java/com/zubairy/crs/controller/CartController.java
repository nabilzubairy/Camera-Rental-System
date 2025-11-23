package com.zubairy.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zubairy.crs.model.Cart;
import com.zubairy.crs.service.CartService;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CartController {
	
	@Autowired
	CartService cart;
	
	
	@PostMapping("add")
	public Cart addToCart(@RequestParam int userId, @RequestParam Long cameraId) {
	    return cart.addToCart(userId, cameraId);
	}

	@GetMapping("{userId}")
	public List<Cart> getCart(@PathVariable Long userId) {
	    return cart.getCart(userId);
	}
	
	@DeleteMapping("/clear/{userId}")
	public void clearCart(@PathVariable int userId) {
	    cart.clearCart(userId);
	}


}
