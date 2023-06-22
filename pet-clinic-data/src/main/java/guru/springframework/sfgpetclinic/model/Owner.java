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
@Builder
@Table(name = "owners")
public class Owner extends Person{
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<Pet> pets=new HashSet<>();
    @Column(name ="city" )
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "address")
    private String address;

}
