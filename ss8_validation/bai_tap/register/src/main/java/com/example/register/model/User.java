package com.example.register.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname", columnDefinition = "VARCHAR(45)", nullable = false)
    private String Firstname;
    @Column(name = "lastname", columnDefinition = "VARCHAR(45)", nullable = false)
    private String Lastname;
    @Column(name = "phonenumber", columnDefinition = "VARCHAR(15)", nullable = false)
    private String Phonenumber;
    @Column(name = "age", columnDefinition = "INT CHECK (age >= 18)", nullable = false)
    private int Age;
    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String Email;

}
