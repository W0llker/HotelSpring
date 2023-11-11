package itAcadamy.mapper;

import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import itAcadamy.entity.Amenities;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AmenitiesMapper extends SupperMapper<Amenities, AmenitiesRequest, AmenitiesResponse> {
}
