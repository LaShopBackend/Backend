package practic.la_shop.services;

import practic.la_shop.dto.ProductDto;

import java.util.List;

public interface FavouritesService {

    List<ProductDto> getFavouritesList(long userId);

    void deleteFavourites();


    void addProductToFavourites(long userId, long productId);

    void deleteFavourite(long userId, long productId);
}
