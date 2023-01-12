package ru.BDDemo.DAO;

import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.Barista;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;
import ru.BDDemo.Company.Employers.Intern;

import java.util.List;

public interface CompanyDAO {
    long create(Company company);
    Company find(long company_id);
    long updateCompany(long company_id, String company);
    void deleteEmployer(long employer_id);
    Employer findEmployerById(long employer_id);
    void addIntern(Intern intern, long company_id);
    void addBarista(Barista barista, long company_id);
    List<Employer> getEmployerByRole(CFRole role, long company_id);
//    Barista findBaristaById(long barista_id);
//    Employer findEmployerById(long employer_id);
    long updateEmployer(long employer_id, String newName);
    void deleteCompany(long company_id);
}
