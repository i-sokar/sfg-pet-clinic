package guru.springframework.sfgpetclinic.services.JPA;

import guru.springframework.Repos.OwnerRepo;
import guru.springframework.Repos.PetRepo;
import guru.springframework.Repos.PetTypeRepo;
import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepo ownerRepo;
    @Mock
    PetRepo petRepo;
    @Mock
    PetTypeRepo petTypeRepo;
    @InjectMocks
    OwnerJpaService jpaService;

    Owner retOwner;
    String lName="smith";
    @BeforeEach
    void setUp() {
        retOwner= Owner.builder().id(6L).lastName(lName).build();
    }

    @Test
    void findall() {
        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(Owner.builder().id(2L).build());
        ownerSet.add(Owner.builder().id(4L).build());

        when(ownerRepo.findAll()).thenReturn(ownerSet);

        Set<Owner> owners=jpaService.findall();

        assertNotNull(owners);
        assertEquals(2,owners.size());

    }

    @Test
    void findById() {

    when(ownerRepo.findById(anyLong())).thenReturn(Optional.of(retOwner));

    Owner owner=jpaService.findById(1L);
    assertNotNull(owner);

    }
    @Test
    void findByIdNotFound(){

        when(ownerRepo.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner=jpaService.findById(1L);
        assertNull(owner);

    }

    @Test
    void save() {

        Owner ownerSave= Owner.builder().id(1L).build();

        when(ownerRepo.save(any())).thenReturn(retOwner);

        Owner savedOwner=jpaService.save(ownerSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        jpaService.delete(retOwner);

        verify(ownerRepo).delete(any());
    }

    @Test
    void deleteById() {

        jpaService.deleteById(1L);

        verify(ownerRepo).deleteById(anyLong());
    }

    @Test
    void findBylastName() {
        Owner owner= Owner.builder().lastName(lName).build();
        when(ownerRepo.findByLastName(any())).thenReturn(owner);
        Owner smith=jpaService.findBylastName(lName);
        assertEquals(lName,smith.getLastName());
        verify(ownerRepo).findByLastName(any());
    }
}