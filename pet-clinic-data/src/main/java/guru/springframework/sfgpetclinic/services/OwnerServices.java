package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface OwnerServices  extends CrudService<Owner,Long>{

    Owner findBylastName(String lastname);

}
