package com.taskmanager.todo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskDTO {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private LocalDateTime dueDate;
}
