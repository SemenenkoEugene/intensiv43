package ru.aston.servlet_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Movie {
    private Integer id;
    private Integer director;
    private String name;
    private Integer yearOfProduction;
}
