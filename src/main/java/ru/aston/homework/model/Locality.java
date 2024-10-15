package ru.aston.homework.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String point;

    private String region;

    @OneToMany
    @JoinTable(name = "locality_attraction_id",
            joinColumns = @JoinColumn(name = "locality_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id", referencedColumnName = "id"))
    private List<Attraction> attraction;

    private double width;

    private double longy;

}
