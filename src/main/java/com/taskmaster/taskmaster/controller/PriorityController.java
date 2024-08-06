package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.entity.Priority;
import com.taskmaster.taskmaster.service.PriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/priority/v1")
@RequiredArgsConstructor
public class PriorityController {

    private final PriorityService priorityService;

    @GetMapping("/")
    public ResponseEntity<List<Priority>> getAllPriorities() {
        return ResponseEntity.ok().body(priorityService.getAllPriorities());
    }
}
