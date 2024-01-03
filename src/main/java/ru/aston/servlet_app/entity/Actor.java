package ru.aston.servlet_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "actor")
public class Actor {
    private Integer id;
    private String name;
    private Integer age;
}
