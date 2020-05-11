package com.tanovait.springpetclinic.repositories;

import com.tanovait.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
