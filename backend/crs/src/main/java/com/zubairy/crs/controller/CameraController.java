package com.zubairy.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zubairy.crs.model.Camera;
import com.zubairy.crs.service.CameraService;

@RestController
@RequestMapping("camera")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CameraController {
	
	@Autowired
	private CameraService cameraService;

	@PostMapping("add")
	public ResponseEntity<?> addCamera(
	        @RequestParam("name") String name,
	        @RequestParam("model") String model,
	        @RequestParam("companyName") String companyName,
	        @RequestParam("price") String price,
	        @RequestParam("description") String description,
	        @RequestParam("image") MultipartFile image) {
		
		System.out.println(name + model + companyName + price + description + image);

	    return cameraService.saveCamera(name, model, companyName, price, description, image);
	}
	
	@GetMapping("all")
	public List<Camera> getAll(){
		return cameraService.getAll();
	}
	
	@GetMapping("{id}")
	public Camera getCamera(@PathVariable Long id) {
	    return cameraService.getCamera(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteCamera(@PathVariable Long id) {
	    cameraService.deleteCamera(id);
	}


}
