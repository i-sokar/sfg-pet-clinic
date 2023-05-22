package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.PetServices;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetServices {
    @Override
    public Set<Pet> findall() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save( object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id    );
    }
}
