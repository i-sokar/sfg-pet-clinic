package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerServices;
import guru.springframework.sfgpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;

public class DataLoader  implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1= new Owner(null,null);
        owner1.setFirstName("ismail");
        owner1.setLastName("sokar");
        owner1.setId(01L);
        ownerServices.save(owner1);

        Owner owner2=new Owner(null,null);
        owner2.setLastName("rawan");
        owner2.setLastName("sokar");
        owner2.setId(02L);

        ownerServices.save(owner2);

        System.out.println("loaded owners");

        Vet vet1= new Vet(null,null);
        vet1.setFirstName("mohamed");
        vet1.setLastName("geysa");
        vet1.setId(01L);
        vetServices.save(vet1);


        Vet vet2=new Vet(null,null);
        vet2.setLastName("donia");
        vet2.setLastName("okasha");
        vet2.setId(02L);
        vetServices.save(vet2);

        System.out.println("loaded vets");

    }
}
