package practic.la_shop.controllers;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.services.FavouritesService;
import practic.la_shop.services.impl.FavouritesServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FavouritesController {

    private final FavouritesService favouritesService;

    @GetMapping("/favourites")
    public ResponseEntity<List<ProductDto>> getFavourites(@RequestParam long userId) {

        List<ProductDto> list = favouritesService.getFavouritesList(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @DeleteMapping("/favourites/{productId}")
//    ResponseEntity<?> deleteProductFromFavourites(@RequestParam long accountId, @PathVariable long productId) {
//
//    }

    @PostMapping("/favourites/delete")
    public String deleteProductFromFavourites(@RequestParam long userId, @RequestParam long productId) {
        favouritesService.deleteFavourite(userId, productId);

        return "redirect:/favourites?userId=" + userId;
    }

    @PostMapping("/favourites/add")
    public String addProductToFavourites(@RequestParam long userId, @RequestParam long productId) {
        favouritesService.addProductToFavourites(userId, productId);

        return "redirect:/favourites?userId=" + userId;
    }
}
