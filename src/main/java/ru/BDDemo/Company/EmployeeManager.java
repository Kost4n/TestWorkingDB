package ru.BDDemo.Company;

import lombok.Getter;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@MappedSuperclass
public class EmployeeManager<T extends Employer> {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<T> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public int getSize() {
        return employees.size();
    }

    public List<T> getEmployees() {
        return employees;
    }
}
