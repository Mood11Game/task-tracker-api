package com.example.task_tracker;

import com.example.task_tracker.controller.TaskPriority;
import com.example.task_tracker.controller.TaskStutas;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=100)
    private String title;

    @NotBlank
    @Size(max=500)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStutas status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
}
