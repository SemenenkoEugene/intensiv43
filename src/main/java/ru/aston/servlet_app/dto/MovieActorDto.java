package ru.aston.servlet_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorDto {
    private String actorName;
    private String movieName;
    private Integer year_of_production;
}
