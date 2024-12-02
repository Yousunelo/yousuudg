package com.example.yousuudg.models;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
// constructor sin argumentos
// constructor con todos los argumentos

@Entity
@Table(name="footballers")
//@Getter
//@Setter
// constructor sin argumentos
// constructor con todos los argumentos

public class FootballerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long registrationNum;
    private String name;
    private String team;
    private String position;
    private Long age;

    public FootballerModel(Long id, Long registrationNum, String name, String team, String position, Long age) {
        this.id = id;
        this.registrationNum = registrationNum;
        this.name = name;
        this.team = team;
        this.position = position;
        this.age = age;
    }

    public FootballerModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(Long registrationNum) {
        this.registrationNum = registrationNum;
    }
}

