package ru.BDDemo.Company.Employers;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "interns")
public class Intern extends Employer {
    @Column(name = "exam")
    private boolean exam;


    public Intern() {
    }

    public Intern(String name, int age, CFRole role, boolean exam) {
        super(name, age, role);
        this.exam = exam;
    }

}
