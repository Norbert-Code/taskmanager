package com.taskmaster.taskmaster.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tm_tasks")
@Data
public class Task {

    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;
}
