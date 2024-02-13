package practic.la_shop.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Account;
import practic.la_shop.models.Favourites;
import practic.la_shop.models.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavouritesDto {

    private long id;
    private Account account;
    private Product product;

    public static FavouritesDto from(Favourites favourites) {
        return FavouritesDto.builder()
                .id(favourites.getId())
                .account(favourites.getAccount())
                .product(favourites.getProduct())
                .build();
    }

    public static List<FavouritesDto> from(List<Favourites> favourites) {
        return favourites.stream().map(FavouritesDto::from).toList();
    }
}
