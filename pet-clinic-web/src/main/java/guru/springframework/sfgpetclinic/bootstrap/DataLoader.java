package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerServices;
import guru.springframework.sfgpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
    }

    @Override
    public void run(String... args) throws Exception {

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
