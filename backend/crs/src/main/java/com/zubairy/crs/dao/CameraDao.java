package com.zubairy.crs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zubairy.crs.model.Camera;

@Repository
public interface CameraDao extends JpaRepository<Camera, Long> {

}
