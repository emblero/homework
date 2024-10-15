package ru.aston.homework.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "assistance_attraction_id")
public class AssistanceAttractionId {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assistance_id", nullable = false)
    private Assistance assistance;

    @Column(name = "attraction_id")
    private Long attractionId;

}