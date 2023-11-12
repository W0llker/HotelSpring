package itAcadamy.controller;

import controller.CrudController;
import controller.PersonControllerApi;
import dto.DeleteOrFindDto;
import dto.person.PersonRequest;
import dto.person.PersonResponse;
import itAcadamy.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PersonApi;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController extends CrudController<PersonRequest, PersonResponse> implements PersonControllerApi {
    private final PersonApi personApi;

    public PersonController(PersonService personApi) {
        super(personApi);
        this.personApi = personApi;
    }

    @Override
    public List<PersonResponse> getAllPersonByHotel(DeleteOrFindDto dto) {
        return personApi.getAllPersonInHotel(dto.getId());
    }

    @Override
    public List<PersonResponse> getPersonPost(PersonRequest personRequest, DeleteOrFindDto dto) {
        return personApi.getPersonPost(dto.getId(), personRequest.getPost());
    }
}
