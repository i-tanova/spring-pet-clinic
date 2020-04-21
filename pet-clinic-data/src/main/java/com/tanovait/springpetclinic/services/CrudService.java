package com.tanovait.springpetclinic.services;

import java.util.List;
import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T object);

    Set<T> getAll();

    void delete(T object);

    void deleteById(ID id);
}
