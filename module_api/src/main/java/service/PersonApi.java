package service;

import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;
import dto.person.PersonRequest;
import dto.person.PersonResponse;
import dto.person.Post;

import java.util.List;

public interface PersonApi {
    void addPerson(Long hotelId, PersonRequest personRequest);
    List<PersonResponse> getAllPersonInHotel(Long idHotel);
    List<PersonResponse> getAllPersonInHotelWithPost(Long idHotel, Post post);
    PersonRequest findPersonById(Long idPerson);
    void deletePerson(Long idPerson);
    void updatePerson(PersonRequest personRequest);
}
