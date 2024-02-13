package practic.la_shop.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Account;
import practic.la_shop.models.Cart;
import practic.la_shop.models.Product;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {

    private long id;
    private long productId;
    private double size;
    private int quantity;
    private long accountId;

    public static CartDto from(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .productId(cart.getProduct().getId())
                .size(cart.getSize())
                .quantity(cart.getQuantity())
                .accountId(cart.getAccount().getId())
                .build();
    }

    public static List<CartDto> from(List<Cart> carts) {
        return carts.stream().map(CartDto::from).toList();
    }

}
