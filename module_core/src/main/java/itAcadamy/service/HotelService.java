package itAcadamy.service;


import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.image.ImageRequest;
import itAcadamy.entity.*;
import itAcadamy.exception.HotelException;
import itAcadamy.exception.ImageSaveException;
import itAcadamy.mapper.HotelMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import itAcadamy.repository.HotelDao;
import service.CrudService;
import service.HotelApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class HotelService extends CrudService<Hotel,HotelRequest, HotelResponse> implements HotelApi {
    private final HotelDao hotelDao;

    public HotelService(HotelMapper hotelMapper, HotelDao hotelDao) {
        super(hotelMapper, hotelDao);
        this.hotelDao = hotelDao;
    }

    @Override
    @Transactional
    public void addImageHotel(ImageRequest imageRequest) {
        Hotel hotel = Optional.of(hotelDao.findById(imageRequest.getHotelRequest().getId()).orElseThrow(() -> new RuntimeException("Ошибка"))).get();
        if (hotel.getImage().size() > 0)
            hotel.getImage().forEach(imageHotel -> {
                if (imageHotel.getName().equals(imageRequest.getName()))
                    throw new ImageSaveException("Данная картинка уже сохранена");
            });
        try {
            hotel.getImage().add(new ImageHotel(imageRequest.getName(), Files.readAllBytes(Paths.get(imageRequest.getUrl()))));
        } catch (IOException e) {
            throw new ImageSaveException("Ошибка сохранения");
        }
        hotelDao.save(hotel);
    }

    @Override
    @Transactional
    public void deleteImageHotel(ImageRequest imageRequest) {
        Hotel hotel = hotelDao.findById(imageRequest.getHotelRequest().getId()).orElseThrow(() -> new HotelException("Отель не найден"));
        hotel.getImage().removeIf(imageHotel -> imageHotel.getName().equals(imageRequest.getName()));
    }
}
