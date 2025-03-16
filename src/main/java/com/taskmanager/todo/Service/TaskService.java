package com.taskmanager.todo.Service;

import com.taskmanager.todo.Entity.TaskEntity;
import com.taskmanager.todo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskEntity saveTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }
}
