package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetServices  extends CrudService<Pet,Long>{

}
