package aaagt.hibernate.persons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class PersonId implements Serializable {

    @Column(name = "name", nullable = false, length = 32)
    String name;

    @Column(name = "surname", nullable = false, length = 32)
    String surname;

    @Column(name = "age", nullable = false)
    Integer age;

}
