package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.stereotype.Service;

@Service

public interface PetTypeService  extends  CrudService<PetType,Long>{


}
