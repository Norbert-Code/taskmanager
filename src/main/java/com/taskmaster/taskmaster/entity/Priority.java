package com.taskmaster.taskmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tm_priority")
public class Priority {
    @Id
    private Long id;
    private String name;
}
