package practic.la_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import practic.la_shop.dto.CategoryDto;
import practic.la_shop.models.Category;
import practic.la_shop.models.Product;


import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    // метод ищет продукты по категории
    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findProductsByCategory(long categoryId);

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findProductsByCategoryLimited(long categoryId, Pageable pageable);


    // метод ищет категорию по id продукта
    @Query("SELECT p.category FROM Product p WHERE p.id = ?1")
    Category findCategoryByProductId(long productId);
}
