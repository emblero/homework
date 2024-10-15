package ru.aston.homework.model;

import jakarta.persistence.*;
import lombok.*;
import ru.aston.homework.model.enums.AttractionType;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "attraction")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date date;

    private String description;

    @Column(name = "type_of_attraction")
    private AttractionType typeOfAttraction;

    @ManyToOne
    @JoinColumn(name = "id_locality")
    private Locality locality;

    @ManyToMany
    @JoinTable(name = "attraction_assistance_id",
            joinColumns = @JoinColumn(name = "attraction_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "assistance_id", referencedColumnName = "id"))
    private List<Assistance> assistance;
}
