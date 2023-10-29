package service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;

public interface ClientApi {
    void add(ClientRequest clientRequest);

    void delete(ClientRequest clientRequest);

    void update(ClientRequest clientRequest);

    ClientResponse findById(Long id);
}
