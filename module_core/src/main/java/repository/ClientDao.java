package repository;


import entity.Client;
import entity.ClientStatus;

import java.util.List;

public interface ClientDao {
    void add(Client client);
    void delete(Long id);
    void update(Long id,Client client);
    Client findById(Long id);
    List<Client> getAllClientStatus(ClientStatus clientStatus);
}
