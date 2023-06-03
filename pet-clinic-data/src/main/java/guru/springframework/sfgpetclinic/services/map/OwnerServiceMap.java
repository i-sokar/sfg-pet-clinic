package guru.springframework.sfgpetclinic.services.map;

import com.sun.xml.bind.v2.model.core.ID;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.OwnerServices;
import guru.springframework.sfgpetclinic.services.PetServices;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerServices {

private final PetServices petServices;
private final PetTypeService petTypeService;

    public OwnerServiceMap(PetServices petServices, PetTypeService petTypeService) {
        this.petServices = petServices;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findall() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }


    @Override
    public Owner save(Owner object) {

        if(object != null){
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petServices.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findBylastName(String lastname) {
        return null;
    }
}
