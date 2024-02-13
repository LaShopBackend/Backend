package practic.la_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private long id;
    private long userId;
    private LocalDate orderDate;
    private long addressId;
    private long cardId;
    private int totalSum;
    private List<Long> productListIds;

    public static OrderDto from(Orders order) {
        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getAccount().getId())
                .orderDate(order.getOrderDate())
                .addressId(order.getAddress().getId())
                .cardId(order.getCard().getId())
                .totalSum(order.getTotalSum())
                .productListIds(order.getProductsList().stream().map(Ordered::getId).toList())
                .build();
    }

    public static List<OrderDto> from(List<Orders> orders) {
        return orders.stream().map(OrderDto::from).toList();
    }

}
