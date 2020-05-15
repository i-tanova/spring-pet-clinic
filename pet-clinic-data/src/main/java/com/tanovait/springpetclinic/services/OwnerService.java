package com.tanovait.springpetclinic.services;

import com.tanovait.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String name);
}
