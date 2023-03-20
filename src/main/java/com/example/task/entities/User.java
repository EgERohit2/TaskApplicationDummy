package com.example.task.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String email, String password, String mob, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.mob = mob;
		this.role = role;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "email_Id")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "mobile_number")
	private String mob;
	@Column(name = "role")
	private String role;
	private Boolean isActive = true;
	@CreationTimestamp
	private Date createdAt;
	@LastModifiedDate
	private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", mob=" + mob + ", role=" + role
				+ "]";
	}
	
	

}
