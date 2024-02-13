package practic.la_shop.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import practic.la_shop.dto.CategoryDto;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.models.Category;
import practic.la_shop.models.Product;
import practic.la_shop.repositories.CategoryRepository;
import practic.la_shop.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return CategoryDto.from(categoryList);
    }

    @Override
    public List<ProductDto> getProductsInCategory(CategoryDto categoryDto) {
        List<Product> productList = categoryRepository.findProductsByCategory(categoryDto.getId());
        return ProductDto.from(productList);
    }

    @Override
    public List<ProductDto> getProductsInCategoryLimited(CategoryDto categoryDto, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<Product> productList = categoryRepository.findProductsByCategoryLimited(categoryDto.getId(), pageable);
        return ProductDto.from(productList);
    }

    // может быть проблема с исключением
    @Override
    public CategoryDto getCategoryById(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        return CategoryDto.from(category.orElseThrow());
    }


    @Override
    public CategoryDto getProductCategory(ProductDto productDto) {
        Category category = categoryRepository.findCategoryByProductId(productDto.getId());
        return CategoryDto.from(category);
    }

    @Override
    public void createCategory(CategoryDto categoryDto) {
        Category newCategory =  Category.builder()
                .name(categoryDto.getName())
                .build();

        categoryRepository.save(newCategory);
    }

    @Override
    public void deleteCategory(CategoryDto categoryDto) {
        categoryRepository.deleteById(categoryDto.getId());
    }
}
