package aaagt.hibernate.app.spring.controller;

import aaagt.hibernate.app.spring.dto.PersonResponseDto;
import aaagt.hibernate.app.spring.repository.PersonRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static aaagt.hibernate.app.spring.mapper.PersonMapper.toResponseDtos;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepositoryJPA repository;

    @GetMapping("/by-city")
    ResponseEntity<List<PersonResponseDto>> byCity(@RequestParam String city) {
        var persons = repository.findByCityOfLiving(city);
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

    @GetMapping("/younger-then")
    ResponseEntity<List<PersonResponseDto>> youngerThen(@RequestParam Integer age) {
        var persons = repository.findByIdAgeLessThan(age);
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

    @GetMapping("/by-fullname")
    ResponseEntity<List<PersonResponseDto>> byFullname(@RequestParam Optional<String> name,
                                                       @RequestParam Optional<String> surname) {
        var persons = repository.findByIdNameAndIdSurname(name, surname);
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

}
