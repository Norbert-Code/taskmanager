package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.entity.Task;
import com.taskmaster.taskmaster.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task/v1")
@RequiredArgsConstructor
@Validated
public class TaskController {

    @Value("${pagination.max-page-size:50}")
    private int maxPageSize;

    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<Page<Task>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        if (pageSize > maxPageSize) {
            pageSize = maxPageSize;
            System.out.println(pageSize);
        }
        return ResponseEntity.ok().body(taskService.getAllTasks(PageRequest.of(page, pageSize)));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Task>> searchTasks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) Long statusId,
            @RequestParam(required = false) Long priorityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        // Create Pageable object
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));

        // Call the service layer to get the page of tasks
        Page<Task> tasksPage = taskService.searchTasks(name, typeId, statusId, priorityId, pageable);
        return ResponseEntity.ok().body(tasksPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@Validated @RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.saveTask(task));
    }

    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@Validated @RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTaskById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
