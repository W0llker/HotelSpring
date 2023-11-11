package controller;

import dto.DeleteOrFindDto;
import dto.order.OrderResponse;
import dto.person.PersonRequest;
import dto.person.PersonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonControllerApi {
    @PostMapping("getAll")
    List<PersonResponse> getAllPersonByHotel(@RequestBody DeleteOrFindDto dto);
    @PostMapping("findPersonPost")
    List<PersonResponse> getPersonPost(@RequestBody PersonRequest personRequest, @RequestBody DeleteOrFindDto dto);
}
