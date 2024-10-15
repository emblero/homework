package ru.aston.homework.service;

import lombok.extern.slf4j.Slf4j;
import ru.aston.homework.dtos.SuccessResponse;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.model.enums.AttractionType;
import ru.aston.homework.model.enums.SortName;
import ru.aston.homework.repository.AttractionRepository;
import ru.aston.homework.repository.LocalityRepository;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class AttractionServiceImp implements AttractionService {
    private final LocalityRepository localityRepository;

    private final AttractionRepository attractionRepository;


    @Override
    public SuccessResponse createAttraction(Attraction attraction) {
        log.info("createAttraction: {}", attraction.getName());
        attractionRepository.save(attraction);
        log.info("Success createAttraction");
        return new SuccessResponse("Достопримечательность добавлена");
    }

    @Override
    public List<Attraction> getAllAttractions(SortName sortName, AttractionType attractionType) {
        log.info("getAllAttractions: {}, {}", sortName, attractionType);
        List<Attraction> attractions = attractionRepository.findAll();
        if (sortName == SortName.AZ) {
            attractions.sort(Comparator.comparing(Attraction::getName));
        }
        else if (sortName == SortName.ZA){
            attractions.sort(Comparator.comparing(Attraction::getName).reversed());
        }
        log.info("Success getAllAttractions");
        return attractions.stream().filter(c ->  c.getTypeOfAttraction()!= attractionType).toList();
    }

    @Override
    public List<Attraction> getAllAttractionByLocalityId(Long localityId) {
        log.info("getAllAttractionByLocalityId: {}", localityId);
        List<Attraction> attractions = attractionRepository.findAllByLocality(localityRepository.findById(localityId).get());
        log.info("Success getAllAttractionByLocalityId");
        return attractions;
    }

    @Override
    public SuccessResponse updateAttractionById(Long id, String description) {
        log.info("updateAttractionById: {}, {}", id, description);
        attractionRepository.updateAttractionById(id, description);
        log.info("Success updateAttractionById");
        return new SuccessResponse("Достопримечательность обновлена");
    }

    @Override
    public SuccessResponse deleteAttraction(Long id) {
        log.info("deleteAttraction: {}", id);
        attractionRepository.deleteById(id);
        log.info("Success deleteAttraction");
        return new SuccessResponse("Достопримечательность удалена");
    }
}
