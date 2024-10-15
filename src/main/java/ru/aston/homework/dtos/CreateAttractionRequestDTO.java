package ru.aston.homework.dtos;

import lombok.Builder;
import ru.aston.homework.model.enums.AttractionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAttractionRequestDTO {

    private String name;

    private Date date;

    private String description;

    private AttractionType typeOfAttraction;

    //private Long localityId;
    //private List<Long> assistanceId;
}