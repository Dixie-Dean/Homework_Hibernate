package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findPersonByPersonalData_Age(int personalData_age);

    Optional<Person> findPersonByPersonalData_NameAndPersonalData_Surname(
            String personalData_name, String personalData_surname);
}
