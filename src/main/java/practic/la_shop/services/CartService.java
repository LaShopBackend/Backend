package practic.la_shop.services;

import practic.la_shop.dto.CartDto;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.models.Cart;

import java.util.List;

public interface CartService {

    List<ProductDto> takeProductsInCart(long userId);

    List<CartDto> takeCart(long userId);

    void minusCount(long itemId, long userId, double size);

    void plusCount(long itemId, long userId, double size);
    void deleteItem(long itemId, long userId, double size);

    void addToCart(long itemId, long userId, double size);
}
