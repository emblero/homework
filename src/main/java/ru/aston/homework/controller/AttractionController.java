package ru.aston.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.aston.homework.dtos.*;
import ru.aston.homework.mappers.AttractionMapper;
import ru.aston.homework.mappers.LocalityMapper;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.service.AttractionService;
import ru.aston.homework.service.AttractionServiceImp;
import ru.aston.homework.service.LocalityService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Slf4j
@RestController // Используйте @RestController для упрощения
@RequiredArgsConstructor
@RequestMapping("/attractions") // Общий путь для всех методов контроллера
public class AttractionController {
    public final AttractionService attractionService;
    private final LocalityService localityService;
    private final AttractionMapper attractionMapper;
    private final LocalityMapper localityMapper;

    @PostMapping
    public SuccessResponse createAttraction(@RequestBody CreateAttractionRequestDTO request) {
        try {
            Attraction attraction = attractionMapper.toEntity(request);
            return attractionService.createAttraction(attraction);
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return null;
        }
    }

    @GetMapping
    public GetAttractionsDTO getAllAttractions(@RequestBody GetAllAttractionRequestDTO request) {
        try {
            List<Attraction> attractions = attractionService.getAllAttractions(request.getSort(), request.getType());
            return GetAttractionsDTO.builder()
                    .listAttraction(attractions)
                    .build();
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return null;
        }
    }

    @GetMapping("/locality/{id}") // Уникальный путь для получения аттракционов по идентификатору местности
    public GetAttractionsDTO getAllAttractionByLocalityId(@PathVariable Long id) {
        try {
            List<Attraction> attractions = attractionService.getAllAttractionByLocalityId(id);
            return GetAttractionsDTO.builder()
                    .listAttraction(attractions)
                    .build();
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return null;
        }
    }

    @PutMapping("/{id}") // Уникальный путь для обновления аттракциона по идентификатору
    public SuccessResponse updateAttractionById(@PathVariable Long id, @RequestBody UpdateAttractionByIdRequest request) {
        try {
            return attractionService.updateAttractionById(id, request.getDescription());
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return null;
        }
    }

    @DeleteMapping("/{id}") // Уникальный путь для удаления аттракциона по идентификатору
    public SuccessResponse deleteById(@PathVariable Long id) {
        try {
            return attractionService.deleteAttraction(id);
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return null;
        }
    }

    @PostMapping("/localities") // Уникальный путь для создания местности
    public SuccessResponse createLocality(@RequestBody CreateLocalityDTO request) {
        try {
            return localityService.addLocality(localityMapper.toEntity(request));
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return null;
        }
    }
}
