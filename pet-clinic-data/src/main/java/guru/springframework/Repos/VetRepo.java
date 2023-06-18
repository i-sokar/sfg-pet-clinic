package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet,Long> {
}
