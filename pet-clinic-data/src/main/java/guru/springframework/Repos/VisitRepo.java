package guru.springframework.Repos;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit,Long> {
}
