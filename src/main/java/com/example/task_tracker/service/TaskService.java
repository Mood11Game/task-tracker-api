package com.example.task_tracker.service;

import com.example.task_tracker.Task;
import com.example.task_tracker.TaskRepository;
import com.example.task_tracker.controller.TaskStutas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(long id)
    {
        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
    }

    public void deleteTask(long id)
    {
        taskRepository.deleteById(id);
    }

    public Task updateTask(long id, Task updateTask)
    {
        Task task = taskRepository.findById(id).orElseThrow();

        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setStatus(updateTask.getStatus());
        task.setPriority(updateTask.getPriority());

        return taskRepository.save(task);
    }

    public List<Task> getTaskByStatus(TaskStutas status)
    {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTaskSorted(String field, String direction)
    {
        Sort sort = direction.equalsIgnoreCase("decs")
                ? Sort.by(field).descending()
                :Sort.by(field).ascending();

        return taskRepository.findAll(sort);
    }

    public List<Task> searchByTitle(String title)
    {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public Page<Task> getAllTasks(Pageable pageable)
    {
        return taskRepository.findAll(pageable);
    }
}
