package guru.springframework.sfgpetclinic.services.JPA;

import guru.springframework.Repos.VetRepo;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpa")
public class VetsJpaService implements VetServices {

    private final VetRepo vetRepo;

    public VetsJpaService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;

    }

    @Override
    public Set<Vet> findall() {
        Set<Vet> vets=new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
            vetRepo.deleteById(aLong);
    }


}
