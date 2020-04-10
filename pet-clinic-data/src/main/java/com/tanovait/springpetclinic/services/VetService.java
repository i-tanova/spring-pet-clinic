package com.tanovait.springpetclinic.services;

import com.tanovait.springpetclinic.model.Pet;
import com.tanovait.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById();

    Vet findByLastName(String name);

    Vet save(Vet owner);

    Set<Vet> getAll();
}
