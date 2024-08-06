package com.taskmaster.taskmaster.repository;

import com.taskmaster.taskmaster.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}