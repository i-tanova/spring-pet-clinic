package com.tanovait.springpetclinic.services.map;

import com.tanovait.springpetclinic.model.Owner;
import com.tanovait.springpetclinic.model.Pet;
import com.tanovait.springpetclinic.services.CrudService;
import com.tanovait.springpetclinic.services.OwnerService;
import com.tanovait.springpetclinic.services.PetService;
import com.tanovait.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        // If pet type is not saved. Save it!!
                       if(pet.getPetType().getId() == null){
                           pet.setPetType(petTypeService.save(pet.getPetType()));
                       }
                    }else{
                        throw new RuntimeException("Pet type is required");
                    }

                    if(pet.getId() == null){
                       Pet savedPet =  petService.save(pet);
                       pet.setId(savedPet.getId());
                    }
                });
            }
        }
        return super.save(object);
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

    @Override
    public Owner findByLastName(String name) {
        return null;
    }
}
