package controller;

import dto.DeleteOrFindDto;
import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import dto.hotel.HotelRequest;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
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
    OrderResponse orderFormation(@RequestBody OrderRequest orderRequest);

    @PostMapping("checkFreeRooms")
    BigDecimal checkFreeRooms(@RequestBody OrderRequest orderRequest);

    @PostMapping("paymentOrder")
    void paymentOrder(@RequestBody DeleteOrFindDto dto);

    @PostMapping("cancelOrder")
    void cancelOrder(@RequestBody DeleteOrFindDto dto);
}
