package repository;

import entity.*;

import java.util.List;

public interface HotelDao {
    void add(Hotel Hotel);

    void delete(Long id);

    void update(Long id, Hotel Hotel);

    Hotel findById(Long id);
}
