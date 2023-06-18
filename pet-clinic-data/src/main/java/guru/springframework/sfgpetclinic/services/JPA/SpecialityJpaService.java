package guru.springframework.sfgpetclinic.services.JPA;

import guru.springframework.Repos.SpecialityRepo;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springjpa")
public class SpecialityJpaService implements SpecialityService {
    private final SpecialityRepo specialityRepo;

    public SpecialityJpaService(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    @Override
    public Set<Speciality> findall() {
        Set<Speciality> specialities= new HashSet<>();
        specialityRepo.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepo.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepo.save(object);
    }

    @Override
    public void delete(Speciality object) {
                specialityRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
                specialityRepo.deleteById(aLong);
    }
}
