package aaagt.hibernate.app.spring.repository;

import aaagt.hibernate.app.spring.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryQuery extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.id.age < :age")
    List<Person> findByIdAgeLessThan(@Param("age") int age);

    @Query("SELECT p FROM Person p WHERE p.id.name = :name AND p.id.surname = :surname")
    List<Person> findByIdNameAndIdSurname(@Param("name") Optional<String> name,
                                          @Param("surname") Optional<String> surname);

}
