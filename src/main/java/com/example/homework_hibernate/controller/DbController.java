package com.example.homework_hibernate.controller;

import com.example.homework_hibernate.entity.Person;
import com.example.homework_hibernate.repository.PersonsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DbController {
    private final PersonsRepository personsRepository;

    public DbController(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personsRepository.findByCityOfLiving(city);
    }

    @GetMapping("/persons-jpql/by-city")
    public List<Person> getPersonsByCityJPQL(@RequestParam String city) {
        return personsRepository.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByCity(@RequestParam Integer age) {
        return personsRepository.findPersonByPersonalData_Age(age);
    }

    @GetMapping("/persons-jpql/by-age")
    public List<Person> getPersonsByCityJPQL(@RequestParam Integer age) {
        return personsRepository.findPersonByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam String name, String surname) {
        return personsRepository.findPersonByPersonalData_NameAndPersonalData_Surname(name, surname);
    }

    @GetMapping("/persons-jpql/by-name-surname")
    public Optional<Person> getPersonsByNameAndSurnameJPQL(@RequestParam String name, String surname) {
        return personsRepository.findPersonByNameAndSurname(name, surname);
    }
}
