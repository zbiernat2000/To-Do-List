package com.zach.todolistbackend.controller;

import com.zach.todolistbackend.exception.ResourceNotFoundException;
import com.zach.todolistbackend.model.Task;
import com.zach.todolistbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //get all tasks
    @GetMapping("/tasks")
    public List<Task> getAllTaks(){
        return taskRepository.findAll();
    }

    //create task
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    //get task by id
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with Id of " + id));
        return ResponseEntity.ok(task);
    }

    //update tasks
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task taskDetails){
    Task task = taskRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found with Id of " + id));

    task.setDescription(taskDetails.getDescription());
    task.setCompleted(taskDetails.isCompleted());

    Task updateTask = taskRepository.save(task);
    return ResponseEntity.ok(updateTask);
    }

    //delete employee rest api
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTask(@PathVariable Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with Id of " + id));

        taskRepository.delete(task);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
