package ru.aston.homework.service;

import ru.aston.homework.dtos.SuccessResponse;
import ru.aston.homework.model.Locality;

public interface LocalityService {
    SuccessResponse addLocality(Locality locality);
}
