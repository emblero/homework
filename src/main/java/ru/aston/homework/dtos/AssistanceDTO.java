package ru.aston.homework.dtos;

import lombok.Builder;
import ru.aston.homework.model.enums.AssistanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistanceDTO {
    private Long id;
    private AssistanceType type;
    private String description;
    private String provider;
}