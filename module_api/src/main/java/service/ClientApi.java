package service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;

public interface ClientApi {
    void add(ClientRequest clientRequest);

    // TODO: 14.10.2023 Добавить dtoFeedback 
    void addFeedbackInOrder(Long orderId);
    void delete(Long id);
    void update(Long id,ClientRequest clientRequest);
    ClientResponse findById(Long id);
}
