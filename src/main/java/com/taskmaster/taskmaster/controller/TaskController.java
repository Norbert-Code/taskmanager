package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.entity.Task;
import com.taskmaster.taskmaster.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task/v1")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> list = taskService.getAllTasks();
        return ResponseEntity.ok().body(list);
    }
}
