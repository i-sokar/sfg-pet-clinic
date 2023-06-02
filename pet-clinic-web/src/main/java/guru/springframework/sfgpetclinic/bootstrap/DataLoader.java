package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerServices;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeService petTypeService) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog= new PetType();
        dog.setName("dog");
        PetType SavedDogPetType= petTypeService.save(dog);



        PetType cat= new PetType();
        cat.setName("cat");
        PetType SavedCatPetType= petTypeService.save(cat);

        Owner owner1= new Owner();
        owner1.setFirstName("ismail");
        owner1.setLastName("sokar");
        ownerServices.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("rawan");
        owner2.setLastName("mohamed");

        ownerServices.save(owner2);

        System.out.println("loaded owners");

        Vet vet1= new Vet();
        vet1.setFirstName("mohamed");
        vet1.setLastName("geysa");
        vetServices.save(vet1);


        Vet vet2=new Vet();
        vet2.setFirstName("donia");
        vet2.setLastName("okasha");
        vetServices.save(vet2);

        System.out.println("loaded vets");

    }
}
