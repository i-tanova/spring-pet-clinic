package com.tanovait.springpetclinic.repositories;

import com.tanovait.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepisotory extends CrudRepository<Owner, Long> {
}
