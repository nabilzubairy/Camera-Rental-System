package com.zubairy.crs.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;



@Entity
public class Camera {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;
    private String companyName;
    private String price;
    private String description;

    @Lob
    private byte[] image;
    
    public Camera() {
    	
	}

	public Camera(Long id, String name, String model, String companyName, String price, String description,
			byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.companyName = companyName;
		this.price = price;
		this.description = description;
		this.image = image;
	}

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Camera [id=" + id + ", name=" + name + ", model=" + model + ", companyName=" + companyName + ", price="
				+ price + ", description=" + description + ", image=" + Arrays.toString(image) + "]";
	}
    
    

}
