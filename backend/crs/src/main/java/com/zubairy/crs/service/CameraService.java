package com.zubairy.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zubairy.crs.dao.CameraDao;
import com.zubairy.crs.model.Camera;

@Service
public class CameraService {
	
	@Autowired
	CameraDao cameraDao;
	
	
	
	public ResponseEntity<?> saveCamera(String name, String model, String companyName,
            String price, String description, MultipartFile file) {

	try {
		Camera camera = new Camera();
		camera.setName(name);
		camera.setModel(model);
		camera.setCompanyName(companyName);
		camera.setPrice(price);
		camera.setDescription(description);
		camera.setImage(file.getBytes());
		
		cameraDao.save(camera);
		
		return ResponseEntity.ok("Camera Saved Successfully");
	
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving camera");
		}
	}



	public List<Camera> getAll() {
		return cameraDao.findAll();
	}



	public Camera getCamera(Long id) {
		return cameraDao.findById(id).orElseThrow();
	}



	public void deleteCamera(Long id) {
		cameraDao.deleteById(id);
	}

}
