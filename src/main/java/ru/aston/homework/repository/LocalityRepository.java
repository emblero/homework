package ru.aston.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.homework.model.Locality;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {
     Locality findById(long id);
    void updateLocalityById();
}
