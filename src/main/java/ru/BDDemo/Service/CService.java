package ru.BDDemo.Service;

import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.Barista;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;
import ru.BDDemo.Company.Employers.Intern;

import java.util.List;

public interface CService {
    long createCompany(Company company);
    Company getCompany(long id);
    void addBarista(Barista barista, long id);
    List<Employer> getEmployersByRole(CFRole cfRole, int id);
    long updateCompany(long company_id, Company company);
    void deleteEmployer(long barista_id);
    Employer findEmployerById(long employer_id);
    void addIntern(Intern intern, long company_id);
    long updateEmployer(long employer_id, String newName);
    public void deleteCompany(long company_id);
}
