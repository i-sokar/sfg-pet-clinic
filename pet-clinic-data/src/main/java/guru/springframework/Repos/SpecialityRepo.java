package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepo extends CrudRepository<Speciality,Long> {
}
