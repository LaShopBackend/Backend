package practic.la_shop.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.models.Product;
import practic.la_shop.repositories.CategoryRepository;
import practic.la_shop.repositories.ProductRepository;
import practic.la_shop.services.CategoryService;
import practic.la_shop.services.ProductsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> getProductList() {
        List<Product> list = productRepository.findAll();
        return ProductDto.from(list);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(ProductDto productDto) {
        productRepository.deleteById(productDto.getId());
    }

    @Override
    public void createNewProduct(ProductDto productDto) {
        Product newProduct = Product.builder()
                .brand(productDto.getBrand())
                .model(productDto.getModel())
                .category(categoryRepository.findCategoryByProductId(productDto.getCategoryId()))
                .color(productDto.getColor())
                .isSoldOut(productDto.isSoldOut())
                .sizesQuantities(productDto.getSizes())
                .build();

        productRepository.save(newProduct);
    }

    @Override
    public ProductDto getProductById(long id) {

        return ProductDto.from(productRepository.getProductsById(id));
    }
}
