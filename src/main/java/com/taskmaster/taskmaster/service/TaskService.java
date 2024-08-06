package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.entity.Task;
import com.taskmaster.taskmaster.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepo taskRepo;

    public Page<Task> getAllTasks(Pageable pageRequest) {
        return taskRepo.findAll(pageRequest);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepo.save(task);
    }

    public boolean deleteTaskById(Long id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Task> searchTasks(String name, Long typeId, Long statusId, Long priorityId, Pageable pageable) {
        return taskRepo.searchTasks(name, typeId, statusId, priorityId, pageable);
    }
}
