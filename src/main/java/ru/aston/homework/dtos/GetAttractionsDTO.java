package ru.aston.homework.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.homework.model.Attraction;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAttractionsDTO {
    List<Attraction> listAttraction;
}
