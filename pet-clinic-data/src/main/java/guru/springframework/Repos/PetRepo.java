package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;

public interface PetRepo extends CrudService<Pet,Long> {
}
