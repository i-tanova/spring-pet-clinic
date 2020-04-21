package com.tanovait.springpetclinic.bootstrap;

import com.tanovait.springpetclinic.model.Owner;
import com.tanovait.springpetclinic.model.Vet;
import com.tanovait.springpetclinic.services.OwnerService;
import com.tanovait.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner("FirstOwner", "SecondNameFirstOwner");
        owner.setId(1L);
        ownerService.save(owner);
        System.out.println("Owner service 1 data saved");

        Owner owner1 = new Owner("SecondOwner", "LastNameSecondOwner");
        owner1.setId(2L);
        ownerService.save(owner1);
        System.out.println("Owner service 2 data saved");

        Vet vet = new Vet("FistVet", "FistVetSecondName");
        vet.setId(1L);
        vetService.save(vet);
        System.out.println("Vet service 1 data saved");

        Vet vet1 = new Vet("SecondVet", "SecondVetSecondName");
        vet1.setId(2L);
        vetService.save(vet1);
        System.out.println("Vet service 2 data saved");
    }
}
