package itAcadamy.controller;

import controller.ClientControllerApi;
import controller.CrudController;
import dto.client.ClientRequest;
import dto.client.ClientResponse;
import itAcadamy.entity.Client;
import itAcadamy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ClientApi;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController extends CrudController<Client, ClientRequest, ClientResponse> implements ClientControllerApi {
    private final ClientApi clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        super(clientService);
        this.clientService = clientService;
    }

    @Override
    public List<ClientResponse> getAllClientStatus(ClientRequest clientRequest) {
        return clientService.getAllClientStatus(clientRequest.getClientStatus());
    }

    @Override
    public List<ClientResponse> getClientByNameSurName(ClientRequest clientRequest) {
        return clientService.getClientByNameSurName(clientRequest);
    }
}
