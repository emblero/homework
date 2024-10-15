package homework.homework.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class Attraction {
    private long id;
    private String name;
    private Date date;
    private String description;
    private Enum typeOfAttraction;
    private Locality location;
    private List<Assistance> assistance = new ArrayList<>();
}
