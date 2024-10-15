package ru.aston.homework.service;

import org.springframework.stereotype.Service;
import ru.aston.homework.dtos.SuccessResponse;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.model.Locality;
import ru.aston.homework.model.enums.AttractionType;
import ru.aston.homework.model.enums.SortName;

import java.util.List;
import java.util.Optional;

@Service
public interface AttractionService {

    SuccessResponse createAttraction(Attraction attraction);

    List<Attraction> getAllAttractions(SortName sortName, AttractionType attractionType);

    List<Attraction> getAllAttractionByLocalityId(Long localityId);

    SuccessResponse updateAttractionById(Long id, String description);

    SuccessResponse deleteAttraction(Long id);
}
