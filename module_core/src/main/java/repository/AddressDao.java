package repository;

import entity.Address;

public interface AddressDao {
    void add(Address address);
    void delete(Address address);
    void update(Long id, Address address);
    Address findById(Long id);
}
