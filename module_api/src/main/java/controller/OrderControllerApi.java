package controller;

import dto.DeleteOrFindDto;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface OrderControllerApi {
    @PostMapping("getAll")
    List<OrderResponse> getAllOrderByHotel(@RequestBody DeleteOrFindDto dto);

    @PostMapping("getAllOrderClient")
    List<OrderResponse> getAllOrderByClient(@RequestBody DeleteOrFindDto dto);

    @PostMapping("orderFormation")
    OrderResponse orderFormation(@RequestBody @Valid OrderRequest orderRequest);

    @PostMapping("checkFreeRooms")
    BigDecimal checkFreeRooms(@RequestBody OrderRequest orderRequest);

    @PostMapping("paymentOrder")
    void paymentOrder(@RequestBody DeleteOrFindDto dto);

    @PostMapping("cancelOrder")
    void cancelOrder(@RequestBody DeleteOrFindDto dto);
}
