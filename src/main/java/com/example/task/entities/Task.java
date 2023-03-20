package com.example.task.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {

	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int id, String name, String desc, User user) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="task_name")
	private String name;
	@Column(name="description")
	private String desc;
	private Boolean isActive=true;
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", desc=" + desc + ", user=" + user + "]";
	}
	
	
	
	
}
