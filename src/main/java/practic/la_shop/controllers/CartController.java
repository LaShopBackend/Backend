package practic.la_shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practic.la_shop.dto.CartDto;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.services.CartService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<List<CartDto>> getAllProduct(@RequestParam long userId) {

        List<CartDto>cartList = cartService.takeCart(userId);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @PostMapping("/cart/minus")
    public String minusQuantity(@RequestParam long userId, @RequestParam long productId, @RequestParam double size) {
        cartService.minusCount(productId, userId, size);

        return "redirect:/cart?userId=" + userId;
    }

    @PostMapping("/cart/plus")
    public String plusQuantity(@RequestParam(value = "userId") long userId, @RequestParam(value = "productId") long productId, @RequestParam double size) {
        cartService.plusCount(productId, userId, size);

        return "redirect:/cart?userId=" + userId;
    }

    @PostMapping("/cart/delete")
    public String deleteProduct(@RequestParam(value = "userId") long userId, @RequestParam(value = "productId") long productId, @RequestParam double size) {
        cartService.deleteItem(productId, userId, size);

        return "redirect:/cart?userId=" + userId;
    }

    @PostMapping("/cart/add")
    public String addNewProduct(@RequestParam(value = "userId") long userId, @RequestParam(value = "productId") long productId, @RequestParam double size) {
        cartService.addToCart(productId, userId, size);

        return "redirect:/cart?userId=" + userId;
    }

}
