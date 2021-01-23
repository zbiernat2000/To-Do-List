package com.zach.todolistbackend.repository;

import com.zach.todolistbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
