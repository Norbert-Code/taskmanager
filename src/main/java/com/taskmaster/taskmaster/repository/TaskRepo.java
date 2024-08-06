package com.taskmaster.taskmaster.repository;

import com.taskmaster.taskmaster.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t " +
            "WHERE (:name IS NULL OR t.name LIKE %:name%) " +
            "AND (:typeId IS NULL OR t.type.id = :typeId) " +
            "AND (:statusId IS NULL OR t.status.id = :statusId) " +
            "AND (:priorityId IS NULL OR t.priority.id = :priorityId)")
    Page<Task> searchTasks(
            @Param("name") String name,
            @Param("typeId") Long typeId,
            @Param("statusId") Long statusId,
            @Param("priorityId") Long priorityId,
            Pageable pageable
    );
}
