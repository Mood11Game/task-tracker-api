package com.example.task_tracker.controller;

import com.example.task_tracker.Task;
import com.example.task_tracker.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.example.task_tracker.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task)
    {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable long id)
    {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id)
    {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @Valid @RequestBody Task task)
    {
        return taskService.updateTask(id, task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStutas status)
    {
        return taskService.getTaskByStatus(status);
    }

    @GetMapping("/sorted")
    public List<Task> getTaskSorted(@RequestParam String field, @RequestParam(defaultValue = "asc") String direction)
    {
        return taskService.getTaskSorted(field, direction);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String title)
    {
        return taskService.searchByTitle(title);
    }

    @GetMapping
    public Page<Task> getAllTask(Pageable pageable)
    {
        return taskService.getAllTasks(pageable);
    }
}