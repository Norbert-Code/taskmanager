package com.taskmaster.taskmaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tm_status")
@Data
public class Status {

    @Id
    private Long id;
    private String name;
    private String description;
}
