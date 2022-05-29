package com.manning.javapersistence.springdatajpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private LocalDate registrationDate;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, LocalDate registrationDate) {
        this.userName = userName;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }2

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
