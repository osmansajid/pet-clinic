package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private OwnerService ownerService;
    private VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Osman");
        owner1.setLastName("Sajid");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("john");
        owner2.setLastName("Doe");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Leo");
        vet1.setLastName("Messi");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sergio");
        vet2.setLastName("Aguero");
        vetService.save(vet2);

        System.out.println("Loaded Data...");
    }
}
