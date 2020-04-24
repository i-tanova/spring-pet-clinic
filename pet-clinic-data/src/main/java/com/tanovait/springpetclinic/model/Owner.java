package com.tanovait.springpetclinic.model;

import net.bytebuddy.matcher.HasSuperClassMatcher;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {
    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    private Set<Pet> pets = new HashSet<Pet>();

}
