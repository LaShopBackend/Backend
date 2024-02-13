package practic.la_shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practic.la_shop.dto.CategoryDto;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.services.CategoryService;

import java.io.Console;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("/categories/{categoryId}")
    ResponseEntity<List<ProductDto>> getCategoryProducts(@PathVariable long categoryId) {
        CategoryDto category = null;
        try {
            category = categoryService.getCategoryById(categoryId);
        } catch (ChangeSetPersister.NotFoundException e) {
            System.err.println("категория не найдена");
        }

        List<ProductDto> categoryList = categoryService.getProductsInCategory(category);


        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    // сделать удаление, чтение, добавление новой
}
