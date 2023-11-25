package itAcadamy.service;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.client.ClientStatus;
import itAcadamy.entity.Client;
import itAcadamy.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import itAcadamy.repository.ClientDao;
import service.ClientApi;
import service.CrudService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService extends CrudService<Client, ClientRequest, ClientResponse> implements ClientApi {
    private final ClientMapper clientMapper;
    private final ClientDao clientDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientMapper clientMapper, ClientDao clientDao, PasswordEncoder passwordEncoder) {
        super(clientMapper, clientDao);
        this.clientMapper = clientMapper;
        this.clientDao = clientDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ClientResponse add(ClientRequest clientRequest) {
        clientRequest.setPassword(passwordEncoder.encode(clientRequest.getPassword()));
        return clientMapper.createResponse(
                clientDao.save(clientMapper.createEntity(clientRequest)));
    }

    @Override
    public ClientResponse update(ClientRequest clientRequest) {
        clientRequest.setPassword(passwordEncoder.encode(clientRequest.getPassword()));
        return clientMapper.createResponse(
                clientDao.save(clientMapper.createEntity(clientRequest)));
    }

    @Override
    public List<ClientResponse> getAllClientStatus(ClientStatus clientStatus) {
        return clientDao.getAllClientStatus(clientStatus).stream().map(clientMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> getClientByNameSurName(ClientRequest clientRequest) {
        return clientDao.getClientByNameSurName(clientRequest.getName(), clientRequest.getSurName()).stream().map(clientMapper::createResponse).collect(Collectors.toList());
    }
}
