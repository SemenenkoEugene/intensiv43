package ru.aston.servlet_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {
    private Integer id;
    private String name;
    private Integer age;
}
