package ru.aston.servlet_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Director {
    private Integer id;
    private String name;
    private Integer age;
}
