package ru.BDDemo.Company;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import ru.BDDemo.Company.Employers.Employer;
import ru.BDDemo.Company.Employers.CFRole;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company extends EmployeeManager<Employer<CFRole>> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Employer<CFRole> director;
//    private int maxEmployerCout;
//    private List<T> entities;

    public Company() {
    }

    public Company(String companyName) {
        super();
        this.companyName = companyName;
    }
//
//    public Company(String companyName, int maxEmployerCout, Employer<CFRole> director) {
//        this.companyName = companyName;
////        this.maxEmployerCout = maxEmployerCout;
//        this.director = director;
//    }

//    public Company(String companyName, int maxEmployerCout) {
//        this.companyName = companyName;
//        this.maxEmployerCout = maxEmployerCout;
//    }
}
