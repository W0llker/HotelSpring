package itAcadamy.mapper;

import dto.client.ClientRequest;
import dto.client.ClientResponse;
import itAcadamy.entity.Client;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends SupperMapper<Client, ClientRequest, ClientResponse> {
}
