package aaagt.hibernate.app.spring.mapper;

import aaagt.hibernate.app.spring.dto.PersonResponseDto;
import aaagt.hibernate.app.spring.entity.Person;

import java.util.List;

public class PersonMapper {

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
