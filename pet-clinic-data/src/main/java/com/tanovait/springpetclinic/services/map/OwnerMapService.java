package com.tanovait.springpetclinic.services.map;

import com.tanovait.springpetclinic.model.Owner;
import com.tanovait.springpetclinic.services.CrudService;
import com.tanovait.springpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Owner> getAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
         super.delete(object);
    }
}
