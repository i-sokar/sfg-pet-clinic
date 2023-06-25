package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {


    OwnerServiceMap ownerServiceMap;
   final Long ownerId= 15L;
   final String sokar="sokar";
    @BeforeEach
    void setUp() {

        ownerServiceMap=new OwnerServiceMap(new PetServiceMap(), new PetTypeMapService());

            ownerServiceMap.save(Owner.builder().id(ownerId).lastName(sokar).build());
    }

    @Test
    void findall() {
        Set<Owner> ownerSet= ownerServiceMap.findall();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findall().size());
    }

    @Test
    void saveExistId() {
        Long id =1L;
        Owner owner=Owner.builder().id(id).build();
        Owner savedOwner=ownerServiceMap.save(owner);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner= ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
    ownerServiceMap.deleteById(ownerId);
    assertEquals(0,ownerServiceMap.findall().size());

    }

    @Test
    void findById() {
        Owner owner= ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findBylastName() {
        Owner name=ownerServiceMap.findBylastName(sokar);
        assertNotNull(name);
        assertEquals(ownerId,name.getId());

    }

    @Test
    void findByLastNameNull() {
        Owner owner1=ownerServiceMap.findBylastName("hasd");
        assertNull(owner1);
    }
}