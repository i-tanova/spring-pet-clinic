package com.tanovait.springpetclinic.bootstrap;

import com.tanovait.springpetclinic.model.Owner;
import com.tanovait.springpetclinic.model.Pet;
import com.tanovait.springpetclinic.model.PetType;
import com.tanovait.springpetclinic.model.Vet;
import com.tanovait.springpetclinic.services.OwnerService;
import com.tanovait.springpetclinic.services.PetService;
import com.tanovait.springpetclinic.services.PetTypeService;
import com.tanovait.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner = new Owner("FirstOwner", "SecondNameFirstOwner");
        owner.setAddress("Address one");
        owner.setCity("City one");
        owner.setTelephone("111111");

        //Create pet
        Pet ownersPet = new Pet();
        ownersPet.setName("Jhonny owners pet");
        ownersPet.setPetType(savedDogPetType);
        ownersPet.setOwner(owner);
        ownersPet.setBirthdate(LocalDate.now());

        owner.getPets().add(ownersPet);
        // Save owner with data
        Owner savedOwner = ownerService.save(owner);
        System.out.println("Owner service 1 data saved");


        Owner owner1 = new Owner("SecondOwner", "LastNameSecondOwner");
        owner1.setAddress("Owner 1 address");
        owner1.setTelephone("22222");
        owner1.setCity("Owner 1 City");

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Owner1 Pet");
        owner1Pet.setPetType(savedCatPetType);
        owner1Pet.setBirthdate(LocalDate.now());
        owner1Pet.setOwner(owner1);

        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);
        System.out.println("Owner service 2 data saved");

        Vet vet = new Vet("FistVet", "FistVetSecondName");
        vetService.save(vet);
        System.out.println("Vet service 1 data saved");

        Vet vet1 = new Vet("SecondVet", "SecondVetSecondName");
        vetService.save(vet1);
        System.out.println("Vet service 2 data saved");
    }
}
