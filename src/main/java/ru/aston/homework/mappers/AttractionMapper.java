package ru.aston.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.aston.homework.dtos.CreateAttractionRequestDTO;
import ru.aston.homework.model.Attraction;

@Mapper(componentModel = "spring")
public interface AttractionMapper {

    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    Attraction toEntity(CreateAttractionRequestDTO attraction);

}
