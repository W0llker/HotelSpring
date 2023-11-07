package service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.client.ClientStatus;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;

import java.util.List;

public interface ClientApi {
    List<ClientResponse> getAllClientStatus(ClientStatus clientStatus);
    List<ClientResponse> getClientByNameSurName(ClientRequest clientRequest);
}
