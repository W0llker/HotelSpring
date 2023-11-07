package itAcadamy.service;

import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import dto.amenities.AmenitiesType;
import itAcadamy.entity.Amenities;
import itAcadamy.mapper.AmenitiesMapper;
import mapper.SupperMapper;
import itAcadamy.repository.AmenitiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AmenitiesApi;
import service.CrudService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmenitiesService extends CrudService<Amenities, AmenitiesRequest, AmenitiesResponse> implements AmenitiesApi {
    private final AmenitiesDao amenitiesDao;
    private final AmenitiesMapper amenitiesMapper;

    @Autowired
    public AmenitiesService(AmenitiesMapper amenitiesMapper, AmenitiesDao amenitiesDao) {
        super(amenitiesMapper, amenitiesDao);
        this.amenitiesDao = amenitiesDao;
        this.amenitiesMapper = amenitiesMapper;
    }

    @Override
    public List<AmenitiesResponse> getAllAmenitiesByHotel(Long idHotel) {
        return amenitiesDao.getAmenities(idHotel).stream().map(amenitiesMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<AmenitiesResponse> getAllAmenitiesByHotelWithType(Long idHotel, AmenitiesType amenitiesType) {
        return amenitiesDao.getAmenitiesType(idHotel, amenitiesType).stream().map(amenitiesMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<AmenitiesResponse> getAmenitiesByName(Long idHotel, String name) {
        return amenitiesDao.getAmenitiesByName(idHotel, name).stream().map(amenitiesMapper::createResponse).collect(Collectors.toList());
    }
}
