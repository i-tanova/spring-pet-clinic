package com.tanovait.springpetclinic.bootstrap;

import com.tanovait.springpetclinic.model.*;
import com.tanovait.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.getAll().size() == 0) {
            System.out.println("Load data");
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology specialty");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery specialty");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry specialty");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner =  Owner.builder().firstName("FirstOwner").secondName("SecondName").pets(new HashSet<>()).build();// new Owner("FirstOwner", "SecondNameFirstOwner");
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


        Owner owner1 =  Owner.builder().firstName("SecondOwner").secondName("SecondName").pets(new HashSet<>()).build();
        owner1.setAddress("Owner 1 address");
        owner1.setTelephone("22222");
        owner1.setCity("Owner 1 City");

        // @Builder pattern here:
        //Owner.builder().address("asdf").city("asdfasd")

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Owner1 Pet");
        owner1Pet.setPetType(savedCatPetType);
        owner1Pet.setBirthdate(LocalDate.now());
        owner1Pet.setOwner(owner1);

        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);
        System.out.println("Owner service 2 data saved");

        Vet vet = new Vet("FistVet", "FistVetSecondName");
        vet.getSpecialties().add(savedRadiology);
        vet.getSpecialties().add(savedDentistry);
        vetService.save(vet);
        System.out.println("Vet service 1 data saved");

        Vet vet1 = new Vet("SecondVet", "SecondVetSecondName");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet1);
        System.out.println("Vet service 2 data saved");

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setPet(owner1Pet);
        visit.setDescription("visit owner 1");
        visitService.save(visit);
        System.out.println("Visit saved");
    }
}
