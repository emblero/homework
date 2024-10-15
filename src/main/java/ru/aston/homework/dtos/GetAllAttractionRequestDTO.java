package ru.aston.homework.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.homework.model.enums.AttractionType;
import ru.aston.homework.model.enums.SortName;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllAttractionRequestDTO {
    SortName sort;
    AttractionType type;
}
