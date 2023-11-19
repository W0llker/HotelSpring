package service;


import dto.person.PersonResponse;
import dto.person.Post;

import java.util.List;

public interface PersonApi {
    List<PersonResponse> getAllPersonInHotel(Long idHotel);

    List<PersonResponse> getPersonPost(Long idHotel, Post post);
}
