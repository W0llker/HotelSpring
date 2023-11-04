package itAcadamy.repository;


import itAcadamy.entity.Client;
import itAcadamy.entity.ClientStatus;

import java.util.List;

public interface ClientDao extends CrudOperation<Client> {
    List<Client> getAllClientStatus(ClientStatus clientStatus);
}
