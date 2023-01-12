package ru.BDDemo.DAO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.Barista;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;
import ru.BDDemo.Company.Employers.Intern;
import ru.BDDemo.DAO.Repository.BaristaRepository;
import ru.BDDemo.DAO.Repository.CompanyRepository;
import ru.BDDemo.DAO.Repository.EmployerRepository;
import ru.BDDemo.DAO.Repository.InternRepository;

import java.util.List;

@Slf4j
@Component
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private BaristaRepository baristaRepository;

    @Autowired
    private InternRepository internRepository;

    @Override
    public long create(Company company) {
        Company savedCompany = companyRepository.save(company);
        return savedCompany.getId();
    }

    @Override
    public Company find(long id) {
        log.info("take company in DAO");
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public long updateCompany(long company_id, String company) {
        companyRepository.updateNameById(company, company_id);
        return company_id;
    }

    @Override
    public long updateEmployer(long employer_id, String newName) {
        employerRepository.updateNameById(newName, employer_id);
        return employer_id;
    }

    @Override
    public void deleteEmployer(long employer_id) {
        employerRepository.deleteById(employer_id);
    }

    @Override
    public void deleteCompany(long company_id) {
        companyRepository.deleteById(company_id);
    }

    @Override
    public Employer findEmployerById(long employer_id) {
       return employerRepository.findById(employer_id).orElse(null);
    }

    @Override
    public void addIntern(Intern intern, long company_id) {
        intern.setCompany(find(company_id));
        internRepository.save(intern);
    }

    @Override
    public void addBarista(Barista barista, long company_id) {
        barista.setCompany(find(company_id));
        baristaRepository.save(barista);
    }

    @Override
    public List<Employer> getEmployerByRole(CFRole role, long company_id) {
        Company company = find(company_id);

        return employerRepository.findByRoleAndCompany(role, company);
    }
}
