package itAcadamy.repository;

import itAcadamy.entity.Person;
import dto.person.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDao extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.hotel.id=:idHotel")
    List<Person> getPerson(Long idHotel);
    @Query("select p from Person p where p.hotel.id=:idHotel and p.post=:post")
    List<Person> getPersonPost(Long idHotel, Post post);
    @Query("select p from Person p where p.hotel.id=:idHotel and p.name=:name and p.surName=:surName")
    Person findPersonNameAndSurName(Long idHotel, String name, String surName);

}
