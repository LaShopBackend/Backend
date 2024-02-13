package practic.la_shop.services;

import practic.la_shop.dto.OrderDto;

import java.util.List;

public interface OrdersService {

    List<OrderDto> getAllOrders();

    List<OrderDto> getUserOrders();


}
