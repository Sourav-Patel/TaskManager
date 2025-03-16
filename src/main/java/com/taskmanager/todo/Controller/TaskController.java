package com.taskmanager.todo.Controller;

import com.taskmanager.todo.Entity.TaskEntity;
import com.taskmanager.todo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<TaskEntity> getTaskByID(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> saveTask(@RequestBody TaskEntity task) {
        // ✅ Use constructor instead of builder()
        TaskEntity newTask = new TaskEntity(task.getTitle(), task.getDescription(), task.getStatus(), task.getDueDate());

        TaskEntity savedTask = taskService.saveTask(newTask);
        return ResponseEntity.ok(savedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}
