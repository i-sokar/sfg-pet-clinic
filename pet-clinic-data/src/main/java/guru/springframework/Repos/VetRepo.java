package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends CrudRepository<Vet,Long> {

    Vet findByLastName(String lastname);
}
