package com.tanovait.springpetclinic.repositories;

import com.tanovait.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
