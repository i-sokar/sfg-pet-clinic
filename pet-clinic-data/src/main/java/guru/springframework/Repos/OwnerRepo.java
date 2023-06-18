package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastname);


}
