package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerServices {

    Owner findBylastName(String lastname);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner>findAll();
}
