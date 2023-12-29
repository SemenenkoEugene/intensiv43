package ru.aston.servlet_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Actor {
    private Integer id;
    private String name;
    private Integer age;
}
