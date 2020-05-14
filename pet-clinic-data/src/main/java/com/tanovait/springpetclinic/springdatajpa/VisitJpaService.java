package com.tanovait.springpetclinic.springdatajpa;

import com.tanovait.springpetclinic.model.Vet;
import com.tanovait.springpetclinic.model.Visit;
import com.tanovait.springpetclinic.repositories.VisitRepository;
import com.tanovait.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public Set<Visit> getAll() {
        Set<Visit> allvisits = new HashSet<>();
        visitRepository.findAll().forEach(allvisits::add);
        return allvisits;
    }

    @Override
    public void delete(Visit object) {
      visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
