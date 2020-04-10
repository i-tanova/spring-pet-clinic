package com.tanovait.springpetclinic.services;

import com.tanovait.springpetclinic.model.Owner;
import com.tanovait.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById();

    Pet findByLastName(String name);

    Pet save(Pet owner);

    Set<Pet> getAll();
}
