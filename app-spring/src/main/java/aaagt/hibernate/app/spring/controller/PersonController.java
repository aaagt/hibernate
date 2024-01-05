package aaagt.hibernate.app.spring.controller;

import aaagt.hibernate.app.spring.dto.PersonResponseDto;
import aaagt.hibernate.app.spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    @GetMapping("/by-city")
    ResponseEntity<List<PersonResponseDto>> byCity(@RequestParam String city) {
        var persons = repository.getPersonsByCity(city);
        var personDtos = persons.stream()
                .map(person -> new PersonResponseDto(
                        person.getId().getName(),
                        person.getId().getSurname(),
                        person.getId().getAge(),
                        person.getPhoneNumber(),
                        person.getCityOfLiving()))
                .toList();
        return ResponseEntity.ok(personDtos);
    }

}
