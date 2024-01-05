package aaagt.hibernate.app.spring.repository;

import aaagt.hibernate.app.spring.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        final var sql = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = :city";
        System.out.println();
        TypedQuery<Person> query = entityManager.createQuery(sql, Person.class)
                .setParameter("city", city.toLowerCase());//city.toLowerCase());
        List<Person> result = query.getResultList();
        return result;
    }

}
