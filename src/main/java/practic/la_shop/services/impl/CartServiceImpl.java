package practic.la_shop.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practic.la_shop.dto.CartDto;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.models.Cart;
import practic.la_shop.repositories.CartRepository;
import practic.la_shop.repositories.ProductRepository;
import practic.la_shop.repositories.UserRepository;
import practic.la_shop.services.CartService;
import practic.la_shop.services.ProductsService;
import practic.la_shop.services.SignUpService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public List<ProductDto> takeProductsInCart(long userId) {
        return cartRepository.findByAccountId(userId).stream().map(Cart::getProduct).map(ProductDto::from).toList();
    }

    public List<CartDto> takeCart(long userId) {
        return cartRepository.findByAccountId(userId).stream().map(CartDto::from).toList();
    }

    @Override
    public void minusCount(long productId, long userId, double size) {
        cartRepository.minusQuantity(userId, productId, size);
    }

    @Override
    public void plusCount(long productId, long userId, double size) {
        cartRepository.plusQuantity(userId, productId, size);
    }

    @Override
    public void deleteItem(long productId, long userId, double size) {
        cartRepository.deleteByProductIdAndAccountIdAndSize(productId, userId, size);
    }


    private final SignUpService signUpService;
    private final ProductsService productsService;

    private final ProductRepository productRepository;
    @Override
    public void addToCart(long itemId, long userId, double size) {
        Optional<Cart> find = cartRepository.findByProductIdAndAccountIdAndSize(itemId, userId, size);

        if (find.isEmpty()) {
            Cart newItemInCart = Cart.builder()
                    .product(productRepository.getProductsById(itemId))
                    .account(signUpService.getAccountById(userId))
                    .quantity(1)
                    .size(size)
                    .build();
            cartRepository.save(newItemInCart);
        } else {
            cartRepository.plusQuantity(userId, itemId, size);
        }
    }
}
