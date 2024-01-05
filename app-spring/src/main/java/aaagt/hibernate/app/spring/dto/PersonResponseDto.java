package aaagt.hibernate.app.spring.dto;

public record PersonResponseDto(
        String name,
        String surname,
        Integer age,
        String phoneNumber,
        String cityOfLiving
) {
}
