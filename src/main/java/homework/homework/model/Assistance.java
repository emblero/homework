package homework.homework.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Assistance {
    private long id;
    private Enum service;
    private String description;
    private String executor;
    private List<Attraction> attraction = new ArrayList<>();

}
