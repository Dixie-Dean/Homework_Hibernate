package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonsRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = entityManager.createQuery("from Person", Person.class).getResultList();
        return personList.stream().filter(person -> person.getCityOfLiving().equals(city)).toList();
    }

//    public List<String> getProductName(String name) {
//        var parameters = new HashMap<String, String>();
//        parameters.put("name", name);
//        return namedParameterJdbcTemplate.queryForList(script, parameters, String.class);
//    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
