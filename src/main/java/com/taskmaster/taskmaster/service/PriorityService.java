package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.entity.Priority;
import com.taskmaster.taskmaster.repository.PriorityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriorityService {

    private final PriorityRepo priorityRepo;

    public List<Priority> getAllPriorities() {
        return priorityRepo.findAll();
    }
}
