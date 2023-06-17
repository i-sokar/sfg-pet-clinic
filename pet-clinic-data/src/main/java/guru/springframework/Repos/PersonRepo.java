package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Person;
import guru.springframework.sfgpetclinic.services.CrudService;

public interface PersonRepo extends CrudService<Person,Long> {
}
