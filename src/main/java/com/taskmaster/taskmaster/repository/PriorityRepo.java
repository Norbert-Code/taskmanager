package com.taskmaster.taskmaster.repository;

import com.taskmaster.taskmaster.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepo extends JpaRepository<Priority, Integer> {
}
