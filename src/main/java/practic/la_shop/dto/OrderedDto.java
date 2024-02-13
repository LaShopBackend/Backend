package practic.la_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Ordered;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderedDto {

    private long id;
    private long productId;
    private int size;
    private long orderId;

    public static OrderedDto from(Ordered ordered) {
        return OrderedDto.builder()
                .id(ordered.getId())
                .productId(ordered.getProduct().getId())
                .size(ordered.getSize())
                .orderId(ordered.getOrder().getId())
                .build();
    }

    public static List<OrderedDto> from(List<Ordered> ordereds) {
        return ordereds.stream().map(OrderedDto::from).toList();
    }
}
