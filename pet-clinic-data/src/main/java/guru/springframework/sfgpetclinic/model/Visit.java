package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "visits")
public class Visit  extends  BaseEntity{
    @Column(name = "date")
    private LocalDate localDate ;
    @Column(name = "description")
    private String description;
@ManyToOne
@JoinColumn(name = "pet_id")
    private  Pet pet;
    public LocalDate getLocalDate() {
        return localDate;
    }
}
