package ru.aston.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aston.homework.dtos.*;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.model.enums.AttractionType;
import ru.aston.homework.model.enums.SortName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.homework.mappers.AttractionMapper;
import ru.aston.homework.mappers.LocalityMapper;
import ru.aston.homework.model.Locality;
import ru.aston.homework.service.AttractionService;
import ru.aston.homework.service.LocalityService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AttractionController.class)
public class AttractionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AttractionService attractionService;

    @Mock
    private LocalityService localityService;

    @Mock
    private AttractionMapper attractionMapper;

    @Mock
    private LocalityMapper localityMapper;

    @InjectMocks
    private AttractionController attractionController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void createAttraction_ShouldReturnSuccessResponse() throws Exception {
        // Given
        CreateAttractionRequestDTO requestDTO = new CreateAttractionRequestDTO();
        requestDTO.setName("Test Attraction");
        requestDTO.setDescription("Test Description");
        requestDTO.setDate(new Date());
        requestDTO.setTypeOfAttraction(AttractionType.RESERVE); // Убедитесь, что этот тип определен

        SuccessResponse successResponse = new SuccessResponse("Attraction created successfully");

        when(attractionMapper.toEntity(any(CreateAttractionRequestDTO.class))).thenReturn(new Attraction());
        when(attractionService.createAttraction(any(Attraction.class))).thenReturn(successResponse);

        // When & Then
        mockMvc.perform(post("/attractions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllAttractions_ShouldReturnAttractions() throws Exception {
        // Given
        GetAllAttractionRequestDTO requestDTO = new GetAllAttractionRequestDTO();
        requestDTO.setSort(SortName.ZA); // Убедитесь, что этот сорт определен
        requestDTO.setType(AttractionType.MUSEUM); // Убедитесь, что этот тип определен

        List<Attraction> attractions = Collections.singletonList(new Attraction());

        when(attractionService.getAllAttractions(any(), any())).thenReturn(attractions);

        // When & Then
        mockMvc.perform(get("/attractions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllAttractionByLocalityId_ShouldReturnAttractions() throws Exception {
        // Given
        Long localityId = 1L;
        List<Attraction> attractions = Collections.singletonList(new Attraction());

        when(attractionService.getAllAttractionByLocalityId(localityId)).thenReturn(attractions);

        // When & Then
        mockMvc.perform(get("/attractions/locality/{id}", localityId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAttractionById_ShouldReturnSuccessResponse() throws Exception {
        // Given
        Long attractionId = 1L;
        UpdateAttractionByIdRequest request = new UpdateAttractionByIdRequest();
        request.setDescription("Updated Description");

        SuccessResponse successResponse = new SuccessResponse("Attraction updated successfully");

        when(attractionService.updateAttractionById(attractionId, request.getDescription())).thenReturn(successResponse);

        // When & Then
        mockMvc.perform(put("/attractions/{id}", attractionId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById_ShouldReturnSuccessResponse() throws Exception {
        // Given
        Long attractionId = 1L;
        SuccessResponse successResponse = new SuccessResponse("Attraction deleted successfully");

        when(attractionService.deleteAttraction(attractionId)).thenReturn(successResponse);

        // When & Then
        mockMvc.perform(delete("/attractions/{id}", attractionId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createLocality_ShouldReturnSuccessResponse() throws Exception {
        // Given
        CreateLocalityDTO requestDTO = new CreateLocalityDTO();
        requestDTO.setPoint("Test Point");
        requestDTO.setRegion("Test Region");

        SuccessResponse successResponse = new SuccessResponse("Locality created successfully");

        when(localityMapper.toEntity(any(CreateLocalityDTO.class))).thenReturn(new Locality());
        when(localityService.addLocality(any(Locality.class))).thenReturn(successResponse);

        // When & Then
        mockMvc.perform(post("/attractions/localities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());
    }
}
