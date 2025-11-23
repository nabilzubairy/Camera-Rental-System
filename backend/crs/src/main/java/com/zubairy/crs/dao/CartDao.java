package com.zubairy.crs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zubairy.crs.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Long>{

	List<Cart> findByUserId(Long userId);

	void deleteByUserId(int userId);

}
