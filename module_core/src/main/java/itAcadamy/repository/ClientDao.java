package itAcadamy.repository;


import itAcadamy.entity.Client;
import dto.client.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    @Query("select c from Client c where c.clientStatus=:clientStatus")
    List<Client> getAllClientStatus(ClientStatus clientStatus);
    @Query("select c from Client c where c.name=:name and c.surName=:surName")
    List<Client> getClientByNameSurName(String name, String surName);
}
