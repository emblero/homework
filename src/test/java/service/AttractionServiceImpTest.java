package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.aston.homework.dtos.SuccessResponse;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.model.Locality;
import ru.aston.homework.model.enums.AttractionType;
import ru.aston.homework.model.enums.SortName;
import ru.aston.homework.repository.AttractionRepository;
import ru.aston.homework.repository.LocalityRepository;
import ru.aston.homework.service.AttractionServiceImp;

import java.util.ArrayList;
import java.util.List;

public class AttractionServiceImpTest {

    @Mock
    private AttractionRepository attractionRepository;

    @Mock
    private LocalityRepository localityRepository;

    @InjectMocks
    private AttractionServiceImp attractionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAttraction_Success() {
        Attraction attraction = new Attraction();
        attraction.setName("Test Attraction");

        SuccessResponse response = attractionService.createAttraction(attraction);

        assertNotNull(response);
        assertEquals("Достопримечательность добавлена", response.getMessage());
        verify(attractionRepository, times(1)).save(attraction);
    }

    @Test
    public void testGetAllAttractions_SortAZ() {
        Attraction attraction1 = new Attraction();
        attraction1.setName("Alpha");
        Attraction attraction2 = new Attraction();
        attraction2.setName("Beta");

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(attraction2);
        attractions.add(attraction1);

        when(attractionRepository.findAll()).thenReturn(attractions);

        List<Attraction> result = attractionService.getAllAttractions(SortName.AZ, AttractionType.MUSEUM);

        assertEquals(2, result.size());
        assertEquals("Alpha", result.get(0).getName());
        verify(attractionRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllAttractions_SortZA() {
        Attraction attraction1 = new Attraction();
        attraction1.setName("Alpha");
        Attraction attraction2 = new Attraction();
        attraction2.setName("Beta");

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(attraction1);
        attractions.add(attraction2);

        when(attractionRepository.findAll()).thenReturn(attractions);

        List<Attraction> result = attractionService.getAllAttractions(SortName.ZA, AttractionType.MUSEUM);

        assertEquals(2, result.size());
        assertEquals("Beta", result.get(0).getName());
        verify(attractionRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllAttractionByLocalityId_Success() {
        Locality locality = new Locality();
        locality.setId(1L);
        Attraction attraction = new Attraction();
        attraction.setLocality(locality);

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(attraction);

        // Убедитесь, что locality не null
        when(attractionRepository.findAllByLocality(any(Locality.class))).thenReturn(attractions);
        when(attractionRepository.findAllByLocality(locality)).thenReturn(attractions);

        List<Attraction> result = attractionService.getAllAttractionByLocalityId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(localityRepository, times(1)).findById(1L);
        verify(attractionRepository, times(1)).findAllByLocality(locality);
    }


    @Test
    public void testUpdateAttractionById_Success() {
        SuccessResponse response = attractionService.updateAttractionById(1L, "Updated Description");

        assertNotNull(response);
        assertEquals("Достопримечательность обновлена", response.getMessage());
        verify(attractionRepository, times(1)).updateAttractionById(1L, "Updated Description");
    }

    @Test
    public void testDeleteAttraction_Success() {
        SuccessResponse response = attractionService.deleteAttraction(1L);

        assertNotNull(response);
        assertEquals("Достопримечательность удалена", response.getMessage());
        verify(attractionRepository, times(1)).deleteById(1L);
    }
}

