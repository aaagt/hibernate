package aaagt.hibernate.persons.api.dto;

public record PersonResponseDto(
        String name,
        String surname,
        Integer age,
        String phoneNumber,
        String cityOfLiving
) {
}
