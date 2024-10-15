package ru.aston.homework.repository;

import org.springframework.stereotype.Repository;
import ru.aston.homework.model.Attraction;
import ru.aston.homework.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {


    List<Attraction> findAllByLocality(Locality locality);

    void updateAttractionById(Long id, String description);

    void deleteById(Long id);
}
