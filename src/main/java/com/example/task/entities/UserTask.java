package com.example.task.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UserTask {

	
	
	public UserTask(int id, User user, Task task, List<UserTaskHistory> history) {
		super();
		this.id = id;
		this.user = user;
		this.task = task;
		this.history = history;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id")
	private Task task;
	@OneToMany(mappedBy = "userTask", cascade = CascadeType.ALL)
	private List<UserTaskHistory> history = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public List<UserTaskHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserTaskHistory> history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "UserTask [id=" + id + ", user=" + user + ", task=" + task + ", history=" + history + "]";
	}
	
	
}
