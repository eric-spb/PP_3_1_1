package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotEmpty(message = "Cannot be empty!")
//    @Size(min = 2, max = 30, message = "Has to be between 2-30 characters")
    @Column(name = "name")
    private String name;

//    @Min(value = 0, message = "Cannot be lower than 0!")
    @Column(name = "age")
    private int age;

//    @NotEmpty(message = "Cannot be empty!")
//    @Size(min = 2, max = 30, message = "Has to be between 2-30 characters")
    @Column(name = "surname")
    private String surname;

    public User(String name, String surname, int id, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.surname = surname;
    }
    public User() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
}
