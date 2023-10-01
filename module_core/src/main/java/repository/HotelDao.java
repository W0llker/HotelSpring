package repository;

import entity.Client;
import entity.Hotel;
import entity.Person;
import entity.Post;

import java.util.List;

public interface HotelDao {
    void add(Hotel Hotel);

    void delete(Long id);

    void update(Long id, Hotel Hotel);

    Hotel findById(Long id);
}
