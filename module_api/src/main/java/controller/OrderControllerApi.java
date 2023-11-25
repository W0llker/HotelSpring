package controller;

import dto.DeleteOrFindDto;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface OrderControllerApi {
    @GetMapping("getAll")
    List<OrderResponse> getAllOrderByHotel(@RequestBody DeleteOrFindDto dto);

    @GetMapping("getAllOrderClient")
    List<OrderResponse> getAllOrderByClient(@RequestBody DeleteOrFindDto dto);

    @PostMapping("checkFreeRooms")
    BigDecimal checkFreeRooms(@RequestBody OrderRequest orderRequest);

    @PostMapping("paymentOrder")
    void paymentOrder(@RequestBody DeleteOrFindDto dto);

    @PostMapping("cancelOrder")
    void cancelOrder(@RequestBody DeleteOrFindDto dto);
}
