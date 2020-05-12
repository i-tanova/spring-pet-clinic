package com.tanovait.springpetclinic.springdatajpa;

import com.tanovait.springpetclinic.model.Vet;
import com.tanovait.springpetclinic.repositories.VetRepository;
import com.tanovait.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public Set<Vet> getAll() {
        Set<Vet> allvets = new HashSet<>();
        vetRepository.findAll().forEach(allvets::add);
        return allvets;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
       vetRepository.deleteById(aLong);
    }
}
