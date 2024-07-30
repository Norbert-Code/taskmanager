package com.taskmaster.taskmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tm_types")
@Data
public class Type {
    @Id
    private Long id;
    private String name;
    private String description;
}
