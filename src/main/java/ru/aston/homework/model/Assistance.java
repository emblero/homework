package ru.aston.homework.model;

import jakarta.persistence.*;
import ru.aston.homework.model.enums.AssistanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Assistance {

    @Id
    private long id;
    @Column(name = "assistance_type")
    private AssistanceType assistanceType;

    private String description;

    private String executor;

    @ManyToMany
    @JoinTable(name = "assistance_attraction_id",
            joinColumns = @JoinColumn(name = "assistance_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id", referencedColumnName = "id"))
    private List<Attraction> attraction;

}
