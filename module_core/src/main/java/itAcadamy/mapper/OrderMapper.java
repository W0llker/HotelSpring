package itAcadamy.mapper;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import itAcadamy.entity.Client;
import itAcadamy.entity.OrderHotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderHotel createEntity(OrderRequest req);

    OrderResponse createResponse(OrderResponse orderResponse);
}
