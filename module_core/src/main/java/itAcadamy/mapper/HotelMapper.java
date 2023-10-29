package itAcadamy.mapper;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import itAcadamy.entity.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends SupperMapper<Hotel, HotelRequest, HotelResponse> {
}
