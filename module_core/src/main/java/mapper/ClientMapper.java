package mapper;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import entity.Address;
import entity.Client;

public class ClientMapper implements MapperEntity<Client, ClientRequest, ClientResponse>{
    @Override
    public Client createEntity(ClientRequest clientRequest) {
        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setSurName(clientRequest.getSurName());
        client.setPassword(clientRequest.getPassword());
        client.setLogin(clientRequest.getLogin());
        client.setDateOfBirth(clientRequest.getDateOfBirth());
        client.setAddress(getUserAddress(clientRequest));
        return client;
    }

    @Override
    public ClientResponse createResponse(Client client) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setName(client.getName());
        clientResponse.setSurName(client.getSurName());
        clientResponse.setLogin(client.getLogin());
        clientResponse.setDateOfBirth(client.getDateOfBirth());
        clientResponse.setAddress(client.getAddress().toString());
        return clientResponse;
    }
    private Address getUserAddress(ClientRequest clientRequest) {
        Address address = new Address();
        address.setCity(clientRequest.getCity());
        address.setCountry(clientRequest.getCountry());
        address.setStreet(clientRequest.getStreet());
        address.setPostalCode(clientRequest.getPostalCode());
        return address;
    }
}
