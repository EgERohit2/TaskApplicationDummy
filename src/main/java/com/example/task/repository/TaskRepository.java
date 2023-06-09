package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.entities.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
