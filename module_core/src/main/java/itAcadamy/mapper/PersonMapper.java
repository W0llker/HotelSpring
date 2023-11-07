package itAcadamy.mapper;

import dto.person.PersonRequest;
import dto.person.PersonResponse;
import itAcadamy.entity.Person;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends SupperMapper<Person, PersonRequest, PersonResponse> {
}
