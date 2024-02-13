package practic.la_shop.repositories;

import io.micrometer.common.lang.NonNullApi;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import practic.la_shop.dto.CategoryDto;
import practic.la_shop.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductsById(long id);

    @Transactional
    void deleteById(long id);


}
