package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.entity.Status;
import com.taskmaster.taskmaster.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/status/v1")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/")
    public ResponseEntity<List<Status>> getAllStatus() {
        return ResponseEntity.ok().body(statusService.getAllStatus());
    }
}
