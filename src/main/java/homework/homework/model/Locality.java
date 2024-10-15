package homework.homework.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Locality {
    private long id;
    private String point;
    private String region;
    private List<Attraction> attractions = new ArrayList<>();
    private double width;
    private double longy;

}
