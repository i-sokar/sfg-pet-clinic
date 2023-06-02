package guru.springframework.sfgpetclinic.model;

import java.time.LocalTime;

public class Visit  extends  BaseEntity{
    private LocalTime localTime;
    private String description;
    private  Pet pet;

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
