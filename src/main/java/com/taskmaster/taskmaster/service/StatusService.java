package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.entity.Status;
import com.taskmaster.taskmaster.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusService {

    private final StatusRepository statusRepo;

    public List<Status> getAllStatus() {
        return statusRepo.findAll();
    }
}
