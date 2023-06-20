package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeService petTypeService
            , SpecialityService specialityService, VisitService visitService) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findall().size();
        if (count== 0){loadData();}

    }

    private void loadData() {
       //creating pets
        PetType dog= new PetType();
        dog.setName("dog");
        PetType SavedDogPetType= petTypeService.save(dog);


        PetType cat= new PetType();
        cat.setName("cat");
        PetType SavedCatPetType= petTypeService.save(cat);
    //creating specs
        Speciality radiology= new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology= specialityService.save(radiology);

        Speciality surgery= new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery=specialityService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry= specialityService.save(dentistry);
        //creating owners
        Owner owner1= new Owner();
        owner1.setFirstName("ismail");
        owner1.setLastName("sokar");
        owner1.setCity("cairo");
        owner1.setAddress("maadi");
        owner1.setTelephone("01461");
        Pet ismailPet= new Pet();
        ismailPet.setPetType(dog);
        ismailPet.setName("gucci");
        ismailPet.setOwner(owner1);
        ismailPet.setBirthdate(LocalDate.now());
        owner1.getPets().add(ismailPet);
        ownerServices.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("rawan");
        owner2.setLastName("mohamed");
        owner2.setCity("alex");
        owner2.setAddress("helwan");
        owner2.setTelephone("5454315");
        Pet rawanPet=new Pet();
        rawanPet.setName("mew");
        rawanPet.setBirthdate(LocalDate.now());
        rawanPet.setPetType(cat);
        rawanPet.setOwner(owner2);
        owner2.getPets().add(rawanPet);
        ownerServices.save(owner2);


        //create visit

        Visit catVisit= new Visit();
        catVisit.setPet(rawanPet);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("flu");
        visitService.save(catVisit);

        System.out.println("loaded owners");
        //creating vets
        Vet vet1= new Vet();
        vet1.setFirstName("mohamed");
        vet1.setLastName("geysa");
        vet1.getSpecialities().add(savedDentistry);
        vetServices.save(vet1);


        Vet vet2=new Vet();
        vet2.setFirstName("donia");
        vet2.setLastName("okasha");
        vet2.getSpecialities().add(savedRadiology);
        vetServices.save(vet2);

        System.out.println("loaded vets");
    }
}
