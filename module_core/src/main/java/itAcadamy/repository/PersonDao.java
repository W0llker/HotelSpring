package itAcadamy.repository;

import itAcadamy.entity.Person;
import dto.person.Post;

import java.util.List;

// TODO: 22.10.2023 Spring data
public interface PersonDao extends CrudOperation<Person>{

    List<Person> getPerson(Long idHotel);

    List<Person> getPersonPost(Long idHotel, Post post);

    Person findPersonNameAndSurName(Long idHotel, String name, String surName);

}
