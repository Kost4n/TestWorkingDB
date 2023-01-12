package ru.BDDemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;

@Configuration
@ComponentScan("ru.BDDemo.Company")
public class CompanyConfig {

    @Bean
    public Company getCompany() {
        Company company = new Company();
        return company;
    }


    @Bean
    public Company getCompany(Employer<CFRole> director) {
        Company company = new Company();
        company.setDirector(director);
        return company;
    }

    @Bean
    public Employer<CFRole> getDirector() {
        return new Employer<CFRole>("Me" , 35, CFRole.Director) {
            @Override
            public void work() {
                System.out.println("directing");
            }
        };
    }
}
