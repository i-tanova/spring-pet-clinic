package com.tanovait.springpetclinic.springdatajpa;

import com.tanovait.springpetclinic.model.Pet;
import com.tanovait.springpetclinic.repositories.PetRepository;
import com.tanovait.springpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    private final PetRepository repository;

    public PetJpaService(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return repository.save(object);
    }

    @Override
    public Set<Pet> getAll() {
        Set<Pet> pets = new HashSet<>();
        repository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public void delete(Pet object) {
         repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
