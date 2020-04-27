package com.tanovait.springpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
    private LocalDate birthdate;
    private Owner owner;
    private PetType petType;
    private String name;

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Owner getOwner() {
        return owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
