package itAcadamy.repository;

import itAcadamy.entity.Person;
import itAcadamy.entity.Post;

import java.util.List;

public interface PersonDao {
    void addPerson(Long idHotel, Person person);

    void deletePerson(Long idHotel, Long idPerson);

    List<Person> getPerson(Long idHotel);

    List<Person> getPersonPost(Long idHotel, Post post);

    Person findPersonNameAndSurName(Long idHotel, String name, String surName);

    void update(Long idHotel, Long idPerson, Person person);
}
