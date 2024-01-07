package aaagt.hibernate.app.spring.dto;

public record PersonCreateDto(
        String name,
        String surname,
        Integer age,
        String phoneNumber,
        String cityOfLiving
) {
}
