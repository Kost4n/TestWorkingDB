package ru.BDDemo.Company.Employers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "baristas")
public class Barista extends Employer {
    @Column(name = "experience")
    private int experience;

    public Barista() {

    }

    public Barista(String name, int age, CFRole CFRole, int experience) {
        super(name, age, CFRole);
        this.experience = experience;
    }
    @Override
    public void work() {
        work();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "experience = " + getExperience() + ", " +
                "name = " + getName() + ", " +
                "role = " + getRole() + ")";
    }
}