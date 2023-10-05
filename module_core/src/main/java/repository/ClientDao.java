package repository;


import entity.Client;

public interface ClientDao {
    void add(Client client);
    void delete(Long id);
    void update(Long id,Client client);
    Client findById(Long id);
}
