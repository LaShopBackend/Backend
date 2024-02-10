package site.lashop.lashopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SneakersTypeDTO {
    Long id;
    String title;
    int price;
    String description;
    List<String> images;
    LocalDateTime creationAt;
    LocalDateTime updatedAt;
    CategoryDTO category;
}
