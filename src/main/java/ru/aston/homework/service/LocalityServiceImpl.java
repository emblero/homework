package ru.aston.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.homework.dtos.SuccessResponse;
import ru.aston.homework.model.Locality;
import ru.aston.homework.repository.LocalityRepository;

@Service
@AllArgsConstructor
public class LocalityServiceImpl implements LocalityService {

    private final LocalityRepository localityRepository;

    @Override
    public SuccessResponse addLocality(Locality locality) {
        localityRepository.save(locality);
        return new SuccessResponse("Создано новое местоположение");
    }
}
