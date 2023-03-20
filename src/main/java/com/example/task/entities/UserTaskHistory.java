package com.example.task.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserTaskHistory {

	
	
	public UserTaskHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTaskHistory(int id, UserTask userTask, User user, String name, String description, TaskStatus status) {
		super();
		this.id = id;
		this.userTask = userTask;
		this.user = user;
		this.name = name;
		this.description = description;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_task_id")
	private UserTask userTask;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskStatus status;

	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserTask getUserTask() {
		return userTask;
	}

	public void setUserTask(UserTask userTask) {
		this.userTask = userTask;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserTaskHistory [id=" + id + ", userTask=" + userTask + ", user=" + user + ", name=" + name
				+ ", description=" + description + ", status=" + status + "]";
	}
	
	
	
	
}
