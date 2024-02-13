package practic.la_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Category;
import practic.la_shop.models.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private long id;
    private String name;
    private List<Long> productIds;

    public static CategoryDto from(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .productIds(category.getProducts().stream().map(Product::getId).toList())
                .build();
    }

    public static List<CategoryDto> from(List<Category> categories) {
        return categories.stream().map(CategoryDto::from).toList();
    }
}
