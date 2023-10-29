package service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.order.OrderRequest;
import dto.order.OrderResponse;

import java.util.List;

public interface OrderApi {
    void add(OrderRequest orderRequest);

    void delete(OrderRequest orderRequest);

    void update(OrderRequest orderRequest);

    OrderResponse findById(Long id);

    List<OrderResponse> getAllOrderByHotel(Long idHotel);

    List<OrderResponse> getAllOrderByClient(Long idClient);
}
