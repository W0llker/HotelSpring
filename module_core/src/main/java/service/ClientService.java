package service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import entity.Client;
import mapper.MapperEntity;
import repository.ClientDao;
import service.ClientApi;

public class ClientService implements ClientApi {
    private final ClientDao clientDao;
    private final MapperEntity<Client,ClientRequest,ClientResponse> mapper;

    public ClientService(ClientDao clientDao, MapperEntity<Client, ClientRequest, ClientResponse> mapper) {
        this.clientDao = clientDao;
        this.mapper = mapper;
    }

    @Override
    public void add(ClientRequest clientRequest) {
        clientDao.add(mapper.createEntity(clientRequest));
    }

    @Override
    public void delete(Long id) {
        clientDao.delete(id);
    }

    @Override
    public void update(Long id,ClientRequest clientRequest) {
        clientDao.update(id,mapper.createEntity(clientRequest));
    }

    @Override
    public ClientResponse findById(Long id) {
        Client client = clientDao.findById(id);
        if(client == null) {
            throw new RuntimeException("Клиент не найден");
        }
        return mapper.createResponse(client);
    }
}
