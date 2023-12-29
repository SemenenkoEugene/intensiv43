package ru.aston.servlet_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private Integer directorId;
    private String name;
    private Integer yearOfProduction;
}
