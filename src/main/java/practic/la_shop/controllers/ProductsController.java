package practic.la_shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practic.la_shop.dto.CategoryDto;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.dto.ProductOnly;
import practic.la_shop.models.Product;
import practic.la_shop.services.CategoryService;
import practic.la_shop.services.ProductsService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final CategoryService categoryService;
    private final Integer relatedProductsLimit;

    @Autowired
    public ProductsController(ProductsService productsService, CategoryService categoryService, @Value("${relatedProductsCount}") int relatedProductLimit) {
        this.productsService = productsService;
        this.relatedProductsLimit = relatedProductLimit;
        this.categoryService = categoryService;
    }


    @GetMapping("/products/{productId}")
    ResponseEntity<ProductOnly> getProductCard(@PathVariable long productId) {
        ProductDto chosenProd = productsService.getProductById(productId);

        CategoryDto categoryDto = null;
        try {
            categoryDto = categoryService.getCategoryById(chosenProd.getCategoryId());
        } catch( ChangeSetPersister.NotFoundException e) {
            System.out.println("Не найдена категория");
        }

        List<ProductDto> relatedProducts = categoryService.getProductsInCategoryLimited(categoryDto, relatedProductsLimit);

        ProductOnly product = ProductOnly.builder()
                .chosenProduct(chosenProd)
                .relatedProducts(relatedProducts)
                .build();

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
