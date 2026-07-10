package com.example.task_tracker;

import com.example.task_tracker.controller.TaskStutas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    List<Task> findByStatus(TaskStutas status);
    List<Task> findByTitleContainingIgnoreCase(String title);
}