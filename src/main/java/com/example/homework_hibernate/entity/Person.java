package com.example.homework_hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "my_default", name = "persons")
public class Person {

    @EmbeddedId
    private PersonalData personalData;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

    @OneToOne(optional = false)
    private Order order;
}
