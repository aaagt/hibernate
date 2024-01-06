package aaagt.hibernate.app.spring.repository;

import aaagt.hibernate.app.spring.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositoryJPA extends JpaRepository<Person, Long> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByIdAgeLessThan(int age);

    List<Person> findByIdNameAndIdSurname(Optional<String> name, Optional<String> surname);

}
