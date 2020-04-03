package com.tanovait.springpetclinic.model;

import java.time.LocalDate;

public class Pet {
    private LocalDate birthdate;
    private Owner owner;
    private PetType petType;

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
}
