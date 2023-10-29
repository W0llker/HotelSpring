package itAcadamy.mapper;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import itAcadamy.entity.Client;
import itAcadamy.entity.Hotel;
import itAcadamy.entity.OrderHotel;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper extends SupperMapper<OrderHotel, OrderRequest, OrderResponse> {
}
