package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})

public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {


    @Override
    public Set<Visit> findall() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {


        if (visit.getPet()==null||visit.getPet().getOwner()==null||visit.getPet().getId()==null||
                visit.getPet().getOwner().getId()==null){
            throw new RuntimeException("invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return findById(id);
    }
}
