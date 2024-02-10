package site.lashop.lashopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CategoryDTO {
    Long id;
    String name;
    String image;
    LocalDateTime creationAt;
    LocalDateTime updatedAt;
}
