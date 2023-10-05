package service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;

public interface ClientApi {
    void add(ClientRequest clientRequest);
    void delete(Long id);
    void update(Long id,ClientRequest clientRequest);
    ClientResponse findById(Long id);
}
