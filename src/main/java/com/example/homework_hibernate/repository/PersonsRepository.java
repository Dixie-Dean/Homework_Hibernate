package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonsRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = entityManager.createQuery("from Person", Person.class).getResultList();
        return personList.stream().filter(person -> person.getCityOfLiving().equals(city)).toList();
    }
}
