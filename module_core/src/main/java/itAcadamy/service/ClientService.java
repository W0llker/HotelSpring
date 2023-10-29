package itAcadamy.service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.feedback.FeedBackRequest;
import itAcadamy.aspect.CustomTransaction;
import itAcadamy.entity.Client;
import itAcadamy.entity.FeedBack;
import itAcadamy.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itAcadamy.repository.ClientDao;
import org.springframework.transaction.annotation.Transactional;
import service.ClientApi;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientApi {
    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    @Override
    @CustomTransaction
    public void add(ClientRequest clientRequest) {
        clientDao.add(clientMapper.createEntity(clientRequest));
    }

    @Override
    @CustomTransaction
    public void delete(ClientRequest clientRequest) {
        clientDao.delete(clientMapper.createEntity(clientRequest));
    }

    @Override
    @CustomTransaction
    public void update(ClientRequest clientRequest) {
        clientDao.update(clientMapper.createEntity(clientRequest));
    }

    @Override
    public ClientResponse findById(Long id) {
        Client client = clientDao.findById(id, Client.class);
        if (client == null) {
            throw new RuntimeException("Клиент не найден");
        }
        return clientMapper.createResponse(client);
    }
}
