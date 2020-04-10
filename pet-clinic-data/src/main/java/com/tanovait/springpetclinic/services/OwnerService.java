package com.tanovait.springpetclinic.services;

import com.tanovait.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById();

    Owner findByLastName(String name);

    Owner save(Owner owner);

    Set<Owner> getAll();
}
