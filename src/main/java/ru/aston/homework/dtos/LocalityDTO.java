package ru.aston.homework.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalityDTO {
    private Long id;
    private String city;
    private String region;
    private double width;
    private double longy;
}