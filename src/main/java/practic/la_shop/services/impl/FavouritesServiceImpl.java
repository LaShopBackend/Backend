package practic.la_shop.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practic.la_shop.dto.ProductDto;
import practic.la_shop.models.Account;
import practic.la_shop.models.Favourites;
import practic.la_shop.models.Product;
import practic.la_shop.repositories.FavouritesRepository;
import practic.la_shop.repositories.ProductRepository;
import practic.la_shop.services.FavouritesService;
import practic.la_shop.services.ProductsService;
import practic.la_shop.services.SignUpService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavouritesServiceImpl implements FavouritesService {

    private final FavouritesRepository favouritesRepository;

    @Override
    public List<ProductDto> getFavouritesList(long userId) {
        List<Product> list = favouritesRepository.findProductsByAccountId(userId);

        return ProductDto.from(list);
    }

    @Override
    public void deleteFavourites() {

    }

    @Override
    public void deleteFavourite(long userId, long productId) {
        favouritesRepository.deleteByAccountIdAndProductId(userId, productId);
    }


    private final SignUpService signUpService;
    private final ProductsService productsService;
    private final ProductRepository productRepository;
    @Override
    public void addProductToFavourites(long userId, long productId) {
        Optional<Favourites> find = favouritesRepository.findByAccountIdAndProductId(userId, productId);
        if (find.isEmpty()) {
            Favourites newFavourite = Favourites.builder()
                    .account(signUpService.getAccountById(userId))
                    .product(productRepository.getProductsById(productId))
                    .build();
            favouritesRepository.save(newFavourite);
        }
    }
}
