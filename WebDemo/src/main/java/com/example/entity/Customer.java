package com.example.entity;
import org.springframework.web.multipart.MultipartFile;

import com.example.validate.Age;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "ID")
	int id;

	@Column(name = "NAME")
	String name;

	@Column(name = "EMAIL")
	@Email(message="please provide valid email")
	String email;

	@Column(name = "AGE")
	@Age
	int age;

	@Transient
	private MultipartFile file;

	@Column(name = "IMAGEFILEPATH")
	private String imagePath;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Customer() {
	}

	public Customer(int id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}

}
