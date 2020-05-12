package com.tanovait.springpetclinic.springdatajpa;

import com.tanovait.springpetclinic.model.Owner;
import com.tanovait.springpetclinic.repositories.OwnerRepisotory;
import com.tanovait.springpetclinic.repositories.PetRepository;
import com.tanovait.springpetclinic.repositories.PetTypeRepository;
import com.tanovait.springpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepisotory ownerRepisotory;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepisotory ownerRepisotory, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepisotory = ownerRepisotory;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String name) {
        return ownerRepisotory.findByLastName(name);
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optional = ownerRepisotory.findById(aLong);
        return optional.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepisotory.save(object);
    }

    @Override
    public Set<Owner> getAll() {
        Set<Owner> allOwners = new HashSet<>();
        ownerRepisotory.findAll().forEach(allOwners::add);
        return allOwners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepisotory.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepisotory.deleteById(aLong);
    }
}
