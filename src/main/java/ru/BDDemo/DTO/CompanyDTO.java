package ru.BDDemo.DTO;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class CompanyDTO {

    long id;
    String name;
    EmployerDTO director;
    List<EmployerDTO> employees;

    public static CompanyDTO from(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setDirector(EmployerDTO.from(company.getDirector()));
        companyDTO.setName(company.getCompanyName());

        List<EmployerDTO> employerDTOList = company.getEmployees().stream()
                .map(EmployerDTO::from)
                .collect(Collectors.toList());
        companyDTO.setEmployees(employerDTOList);
        return companyDTO;
    }

    public Company toCompany() {
        Company company = new Company(this.name);
        company.setDirector(this.director.toEmployer());
        company.getDirector().setCompany(company);
        company.setId(company.getId());

        if (!CollectionUtils.isEmpty(this.employees)) {
            List<Employer<CFRole>> employers = this.employees.stream()
                    .map(EmployerDTO::toEmployer)
                    .peek(e -> e.setCompany(company))
                    .collect(Collectors.toList());
            company.getEmployees().addAll(employers);
        }
        return company;
    }
}
