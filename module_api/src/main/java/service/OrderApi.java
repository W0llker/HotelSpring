package service;

import dto.DeleteOrFindDto;
import dto.order.OrderRequest;
import dto.order.OrderResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderApi {
    List<OrderResponse> getAllOrderByHotel(Long idHotel);

    List<OrderResponse> getAllOrderByClient(Long idClient);

    BigDecimal checkFreeRooms(OrderRequest orderRequest);

    OrderResponse orderFormation(OrderRequest orderRequest);

    void paymentOrder(DeleteOrFindDto dto);

    void cancelOrder(DeleteOrFindDto dto);

    void updateOrder();
}
