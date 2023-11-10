package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    @Query("select p from Person p where p.cityOfLiving = :cityOfLiving")
    List<Person> findByCity(String cityOfLiving);

    List<Person> findPersonByPersonalData_Age(int personalData_age);

    @Query("select p from Person p where p.personalData.age = :age")
    List<Person> findPersonByAge(int age);

    Optional<Person> findPersonByPersonalData_NameAndPersonalData_Surname(
            String personalData_name, String personalData_surname);

    @Query("select p from Person p where p.personalData.name = :name and p.personalData.surname = :surname")
    Optional<Person> findPersonByNameAndSurname(String name, String surname);
}
