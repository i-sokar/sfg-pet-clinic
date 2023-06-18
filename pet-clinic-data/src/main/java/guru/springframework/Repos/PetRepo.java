package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet,Long> {
}
