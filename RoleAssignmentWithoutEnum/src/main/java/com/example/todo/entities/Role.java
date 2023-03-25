package com.example.todo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String rolename, LocalDate date, List<User> user) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.date = date;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "rolename")
	private String rolename;
	@CreationTimestamp
	private LocalDate date;
	@JsonIgnore
	@ManyToMany(mappedBy = "role")
	private List<User> user = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", date=" + date + ", user=" + user + "]";
	}

}
