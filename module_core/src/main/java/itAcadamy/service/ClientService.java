package itAcadamy.service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import itAcadamy.entity.Client;
import itAcadamy.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itAcadamy.repository.ClientDao;
import service.ClientApi;

@Service
public class ClientService implements ClientApi {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public void add(ClientRequest clientRequest) {
        clientDao.add(clientMapper.createEntity(clientRequest));
    }

    @Override
    public void delete(Long id) {
        clientDao.delete(id);
    }

    @Override
    public void update(Long id, ClientRequest clientRequest) {
        clientDao.update(id, clientMapper.createEntity(clientRequest));
    }

    @Override
    public void addFeedbackInOrder(Long orderId) {
        
    }

    @Override
    public ClientResponse findById(Long id) {
        Client client = clientDao.findById(id);
        if (client == null) {
            throw new RuntimeException("Клиент не найден");
        }
        return clientMapper.createResponse(client);
    }
}
