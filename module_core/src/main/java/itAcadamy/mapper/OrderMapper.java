package itAcadamy.mapper;

import dto.order.OrderRequest;
import dto.order.OrderResponse;
import itAcadamy.entity.OrderHotel;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends SupperMapper<OrderHotel, OrderRequest, OrderResponse> {
}
