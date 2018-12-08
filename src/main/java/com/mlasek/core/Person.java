package com.mlasek.core;


import com.google.common.base.Objects;

import java.time.LocalDate;
import java.util.UUID;

public class Person {
    private UUID id;
    private String fullName;
    private LocalDate birthDate;
    private String bio;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equal(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}