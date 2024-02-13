package practic.la_shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.services.ProductsService;
import practic.la_shop.services.impl.ProductsServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductsService productsService;

    @GetMapping("/home")
    ResponseEntity<List<ProductDto>> getAllProduct() {

        List<ProductDto> productDtoList = productsService.getProductList();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

}
