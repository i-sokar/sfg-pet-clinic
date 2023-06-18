package guru.springframework.sfgpetclinic.services.JPA;

import guru.springframework.Repos.OwnerRepo;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class OwnerJpaService implements OwnerServices {

    private final OwnerRepo ownerRepo;

    public OwnerJpaService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Set<Owner> findall() {
        Set<Owner> owners=new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepo.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public void delete(Owner object) {ownerRepo.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);

    }

    @Override
    public Owner findBylastName(String lastname) {
        return ownerRepo.findByLastName(lastname);
    }
}
