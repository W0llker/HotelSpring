package controller;


import dto.client.ClientRequest;
import dto.client.ClientResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientControllerApi {
    @PostMapping("getAll")
    List<ClientResponse> getAllClientStatus(@RequestBody ClientRequest clientRequest);

    @PostMapping("findByNameSurName")
    List<ClientResponse> getClientByNameSurName(@RequestBody ClientRequest clientRequest);
}
