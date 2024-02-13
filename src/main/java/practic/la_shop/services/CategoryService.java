package practic.la_shop.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import practic.la_shop.dto.CategoryDto;
import practic.la_shop.dto.ProductDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategory();

    public List<ProductDto> getProductsInCategoryLimited(CategoryDto categoryDto, int limit);

    List<ProductDto> getProductsInCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(long categoryId) throws ChangeSetPersister.NotFoundException;

    CategoryDto getProductCategory(ProductDto productDto);

    void createCategory(CategoryDto categoryDto);

    void deleteCategory(CategoryDto categoryDto);
}
