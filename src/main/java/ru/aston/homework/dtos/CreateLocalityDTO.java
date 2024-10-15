package ru.aston.homework.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.homework.model.Attraction;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLocalityDTO {
    private Long id;

    private String point;

    private String region;
    private List<Attraction> attraction;
    private double width;
    private double longy;

}
