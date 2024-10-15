package homework.homework.dtos;

import homework.homework.dtos.LocalityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDTO {
    private Long id;
    private String name;
    private Date creationDate;
    private String description;
    private AttractionType type;
    private LocalityDTO locality;
    private List<AssistanceDTO> assistance;
}