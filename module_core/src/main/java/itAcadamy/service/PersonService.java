package itAcadamy.service;

import dto.person.PersonRequest;
import dto.person.PersonResponse;
import dto.person.Post;
import itAcadamy.entity.Person;
import itAcadamy.mapper.PersonMapper;
import itAcadamy.repository.PersonDao;
import org.springframework.stereotype.Service;
import service.CrudService;
import service.PersonApi;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService extends CrudService<Person,PersonRequest, PersonResponse> implements PersonApi {
    private final PersonMapper personMapper;
    private final PersonDao personDao;

    public PersonService(PersonMapper personMapper, PersonDao personDao) {
        super(personMapper, personDao);
        this.personMapper = personMapper;
        this.personDao = personDao;
    }

    @Override
    // TODO: 06.11.2023 Переделать на пагинацию
    public List<PersonResponse> getAllPersonInHotel(Long idHotel) {
        return personDao.getPerson(idHotel).stream().map(personMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<PersonResponse> getPersonPost(Long idHotel, Post post) {
        return personDao.getPersonPost(idHotel, post).stream().map(personMapper::createResponse).collect(Collectors.toList());
    }
}
