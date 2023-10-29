package itAcadamy.service;

import dto.order.OrderRequest;
import dto.order.OrderResponse;
import itAcadamy.entity.OrderHotel;
import itAcadamy.mapper.OrderMapper;
import itAcadamy.repository.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.OrderApi;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderApi {
    private final OrderDao orderDao;
    private final OrderMapper orderMapper;
    @Override
    public void add(OrderRequest orderRequest) {
        orderDao.add(orderMapper.createEntity(orderRequest));
    }

    @Override
    public void delete(OrderRequest orderRequest) {
        orderDao.delete(orderMapper.createEntity(orderRequest));
    }

    @Override
    public void update(OrderRequest orderRequest) {
        //todo пппп
    }

    @Override
    public OrderResponse findById(Long id) {
        return orderMapper.createResponse(Optional.of(orderDao.findById(id, OrderHotel.class)).orElseThrow(() -> new RuntimeException("Нету заказа с таким id = " + id)));
    }

    @Override
    public List<OrderResponse> getAllOrderByHotel(Long idHotel) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllOrderByClient(Long idClient) {
        return null;
    }
}
