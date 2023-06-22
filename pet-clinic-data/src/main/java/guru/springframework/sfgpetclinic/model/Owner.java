package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owners")
public class Owner extends Person{
    @Builder
    public Owner(Long id,String firstName,String lastName,Set<Pet> pets, String city, String telephone, String address) {
        super(id,firstName,lastName);
        this.pets = pets;
        this.city = city;
        this.telephone = telephone;
        this.address = address;
    }

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<Pet> pets=new HashSet<>();
    @Column(name ="city" )
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "address")
    private String address;

}
