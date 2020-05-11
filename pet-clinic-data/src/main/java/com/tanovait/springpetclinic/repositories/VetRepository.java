package com.tanovait.springpetclinic.repositories;

import com.tanovait.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
