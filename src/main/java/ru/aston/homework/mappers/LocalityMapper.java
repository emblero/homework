package ru.aston.homework.mappers;

import org.mapstruct.Mapper;
import ru.aston.homework.dtos.CreateLocalityDTO;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.model.Locality;

@Mapper(componentModel = "spring")
public interface LocalityMapper {
    Locality toEntity(CreateLocalityDTO locality);
}
