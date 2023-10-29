package itAcadamy.mapper;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import itAcadamy.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper extends SupperMapper<Client, ClientRequest, ClientResponse> {
}
