package com.tanovait.springpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    private Set<Speciality> specialties;

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }
}
