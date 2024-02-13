package practic.la_shop.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.models.Product;

import java.util.List;

public interface ProductsService {

    List<ProductDto> getProductList();

    void deleteProduct(long id);

    void deleteProduct(ProductDto productDto);

    void createNewProduct(ProductDto productDto) throws ChangeSetPersister.NotFoundException;

    ProductDto getProductById(long id);

}
