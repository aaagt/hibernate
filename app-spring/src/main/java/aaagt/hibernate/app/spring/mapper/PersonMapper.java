package aaagt.hibernate.app.spring.mapper;

import aaagt.hibernate.app.spring.dto.PersonCreateDto;
import aaagt.hibernate.app.spring.dto.PersonDeleteDto;
import aaagt.hibernate.app.spring.dto.PersonResponseDto;
import aaagt.hibernate.app.spring.entity.Person;
import aaagt.hibernate.app.spring.entity.PersonId;

import java.util.List;

public class PersonMapper {

    public static Person fromCreateDto(PersonCreateDto dto) {
        return new Person(
                new PersonId(
                        dto.name(),
                        dto.surname(),
                        dto.age()
                ),
                dto.phoneNumber(),
                dto.cityOfLiving()
        );
    }


    public static Person fromDeleteDto(PersonDeleteDto dto) {
        return new Person(
                new PersonId(
                        dto.name(),
                        dto.surname(),
                        dto.age()
                ),
                null,
                null
        );
    }

    public static PersonResponseDto toResponseDto(Person person) {
        return new PersonResponseDto(
                person.getId().getName(),
                person.getId().getSurname(),
                person.getId().getAge(),
                person.getPhoneNumber(),
                person.getCityOfLiving());
    }

    public static List<PersonResponseDto> toResponseDtos(List<Person> persons) {
        return persons.stream()
                .map(PersonMapper::toResponseDto)
                .toList();
    }

}
