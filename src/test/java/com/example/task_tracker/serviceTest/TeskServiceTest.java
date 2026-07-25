package com.example.task_tracker.serviceTest;

import com.example.task_tracker.Task;
import com.example.task_tracker.TaskRepository;
import com.example.task_tracker.controller.TaskStutas;
import com.example.task_tracker.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // This tells Spring to set up the dependencies for your JUnit test
class TaskServiceTest {

    @Autowired
    private TaskService taskService; // Spring automatically passes the repository into the constructor for you

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void getTaskById() {
        // 1. ARRANGE: Save a real task into your test database using JUnit setup
        Task task = new Task();
        task.setTitle("Learn JUnit");
        task.setDescription("Testing service layer without Mockito");
        task.setStatus(TaskStutas.TODO);
        Task savedTask = taskRepository.save(task);

        // 2. ACT: Call your service method using the generated ID
        Task result = taskService.getTaskById(savedTask.getId());

        // 3. ASSERT: Use standard JUnit assertions to verify the data
        assertNotNull(result);
        assertEquals("Learn JUnit", result.getTitle());
    }

    @Test
    void updateTask()
    {
        Task task = new Task();
        task.setTitle("Learn JUnit NEW");
        task.setDescription("Testing service layer without Mockito");
        task.setStatus(TaskStutas.TODO);
        Task savedTask = taskRepository.save(task);

        Task taskN = new Task();
        taskN.setTitle("Upd");
        taskN.setDescription("Upd");
        taskN.setStatus(TaskStutas.DONE);

        Task result = taskService.updateTask(savedTask.getId(), taskN);

        //Assert
        assertNotNull(result);
        assertEquals(savedTask.getId(), result.getId());
        assertEquals("Upd", result.getTitle());
        assertEquals("Upd", result.getDescription());
        assertEquals(TaskStutas.DONE, result.getStatus());


    }
}