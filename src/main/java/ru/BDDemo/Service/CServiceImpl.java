package ru.BDDemo.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.Barista;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;
import ru.BDDemo.Company.Employers.Intern;
import ru.BDDemo.DAO.CompanyDAO;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class CServiceImpl implements CService {
    @Autowired
    Company company;

    @Autowired
    CompanyDAO companyDAO;

    @Override
    @Transactional
    public long createCompany(Company company) {
        return companyDAO.create(company);
    }

    @Override
    public Company getCompany(long id) {
        log.info("take company in Service");
        return companyDAO.find(id);
    }

    @Override
    @Transactional
    public void addBarista(Barista barista, long id) {

        companyDAO.addBarista(barista, id);
    }

    @Override
    @Transactional
    public List<Employer> getEmployersByRole(CFRole cfRole, int company_id) {
        return companyDAO.getEmployerByRole(cfRole, company_id);
    }

    @Override
    public long updateCompany(long company_id, Company company) {
        return companyDAO.updateCompany(company_id, company.getCompanyName());
    }

    @Override
    public void deleteEmployer(long employer_id) {
        companyDAO.deleteEmployer(employer_id);
    }

    @Override
    public Employer findEmployerById(long employer_id) {
       return companyDAO.findEmployerById(employer_id);
    }

    @Override
    public void addIntern(Intern intern, long company_id) {
        companyDAO.addIntern(intern, company_id);
    }

    @Override
    public long updateEmployer(long employer_id, String newName) {
        return companyDAO.updateEmployer(employer_id, newName);
    }

    @Override
    public void deleteCompany(long company_id) {
        companyDAO.deleteCompany(company_id);
    }
}
