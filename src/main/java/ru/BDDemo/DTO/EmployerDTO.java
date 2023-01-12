package ru.BDDemo.DTO;

import lombok.Data;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;

@Data
public class EmployerDTO {
    private long id;
    private String name;
    private int age;
    private CFRole role;


    public static EmployerDTO from(Employer<CFRole> employer) {
        EmployerDTO dto = new EmployerDTO();
        dto.setAge(employer.getAge());
        dto.setId(employer.getId());
        dto.setName(employer.getName());
        dto.setRole(employer.getRole());
        return dto;
    }

    public Employer<CFRole> toEmployer() {
        Employer<CFRole> employer = new Employer<>();
        employer.setId(this.id);
        employer.setAge(this.age);
        employer.setName(this.name);
        employer.setRole(this.role);
        return  employer;
    }
}
