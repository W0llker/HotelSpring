package itAcadamy.controller;

import controller.CrudController;
import controller.OrderControllerApi;
import dto.DeleteOrFindDto;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import itAcadamy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrderApi;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController extends CrudController<OrderRequest, OrderResponse> implements OrderControllerApi {
    private final OrderApi orderApi;

    @Autowired
    public OrderController(OrderService orderApi) {
        super(orderApi);
        this.orderApi = orderApi;
    }

    @Override
    public List<OrderResponse> getAllOrderByHotel(DeleteOrFindDto dto) {
        return orderApi.getAllOrderByHotel(dto.getId());
    }

    @Override
    public List<OrderResponse> getAllOrderByClient(DeleteOrFindDto dto) {
        return orderApi.getAllOrderByClient(dto.getId());
    }

    @Override
    public BigDecimal checkFreeRooms(OrderRequest orderRequest) {
        return orderApi.checkFreeRooms(orderRequest);
    }

    @Override
    public OrderResponse orderFormation(OrderRequest orderRequest) {
        return orderApi.orderFormation(orderRequest);
    }

    @Override
    public void paymentOrder(DeleteOrFindDto dto) {
        orderApi.paymentOrder(dto);
    }

    @Override
    public void cancelOrder(DeleteOrFindDto dto) {
        orderApi.cancelOrder(dto);
    }
}
