package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends CrudRepository<Pet,Long> {
}
