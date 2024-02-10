package site.lashop.lashopbackend.mapper;

import org.springframework.stereotype.Component;
import site.lashop.lashopbackend.dto.CategoryDTO;
import site.lashop.lashopbackend.model.Category;

import java.time.LocalDateTime;

@Component
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getDisplayName(),
                category.getImage(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
