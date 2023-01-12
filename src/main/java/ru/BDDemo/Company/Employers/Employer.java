package ru.BDDemo.Company.Employers;

import lombok.Getter;
import lombok.Setter;
import ru.BDDemo.Company.Company;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employer<CFrole> implements Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private CFRole role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Employer(String name, int age, CFRole role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public Employer() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "role = " + role + ")";
    }
}