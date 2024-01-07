package aaagt.hibernate.app.spring.controller;

import aaagt.hibernate.app.spring.dto.PersonCreateDto;
import aaagt.hibernate.app.spring.dto.PersonDeleteDto;
import aaagt.hibernate.app.spring.dto.PersonResponseDto;
import aaagt.hibernate.app.spring.repository.PersonRepositoryQuery;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static aaagt.hibernate.app.spring.mapper.PersonMapper.*;

@Slf4j
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepositoryQuery repository;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_READ")
    public ResponseEntity<List<PersonResponseDto>> getAll() {
        var persons = repository.findAll();
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

    @GetMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"WRITE"})
    public ResponseEntity<?> create(@RequestBody PersonCreateDto personDto) {
        log.info(personDto.toString());
        var person = fromCreateDto(personDto);
        repository.save(person);
        return ResponseEntity.created(URI.create("http://localhost:8080/persons/")).build();
    }

    @GetMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('DELETE') or hasRole('WRITE')")
    public ResponseEntity<PersonResponseDto> delete(@RequestBody PersonDeleteDto personDto) {
        var person = fromDeleteDto(personDto);
        repository.delete(person);
        return ResponseEntity.ok(toResponseDto(person));
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<PersonResponseDto>> byCity(@RequestParam String city) {
        var persons = repository.findByCityOfLiving(city);
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

    @GetMapping("/younger-then")
    @PreAuthorize("hasAuthority('PERSONS.READ')")
    public ResponseEntity<List<PersonResponseDto>> youngerThen(@RequestParam Integer age) {
        var persons = repository.findByIdAgeLessThan(age);
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

    @GetMapping("/by-fullname")
    public ResponseEntity<List<PersonResponseDto>> byFullname(@RequestParam Optional<String> name,
                                                              @RequestParam Optional<String> surname) {
        var persons = repository.findByIdNameAndIdSurname(name, surname);
        var personDtos = toResponseDtos(persons);
        return ResponseEntity.ok(personDtos);
    }

    @GetMapping("/greeting")
    @PostAuthorize("#username == authentication.principal.username")
    public String greeting(@RequestParam String username) {
        log.info("Some work");
        return "Hello " + username;
    }

}
