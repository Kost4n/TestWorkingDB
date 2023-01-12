package ru.BDDemo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.Barista;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Intern;
import ru.BDDemo.DTO.CompanyDTO;
import ru.BDDemo.DTO.EmployerDTO;
import ru.BDDemo.Service.CService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/company")
public class Controller {
    @Autowired
    private CService cService;

    @PostMapping
    public long createCompany(@RequestBody CompanyDTO companyDTO) {
        return cService.createCompany(companyDTO.toCompany());
    }

    @PostMapping("/{id}/employers/intern/add")
    public ResponseEntity addIntern(@RequestBody Intern intern, @PathVariable(name = "id") long company_id) {
        cService.addIntern(intern, company_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/employers/barista/add")
    public ResponseEntity addBarista(@RequestBody Barista barista, @PathVariable(name = "id") long company_id) {
        log.info("add barista in Controller");
        cService.addBarista(barista, company_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public CompanyDTO company(@PathVariable long id) {
        log.info("take company in Controller");
       return CompanyDTO.from(cService.getCompany(id));


    }

    @GetMapping("/employers/{id}")
    public EmployerDTO findEmployerById(@PathVariable(name = "id") long employer_id) {
        return EmployerDTO.from(cService.findEmployerById(employer_id));
    }

    @GetMapping("/{id}/employers/find")
    public ResponseEntity<List<EmployerDTO>> getEmployerByRole(
            @RequestParam(name = "role") CFRole role,
            @PathVariable(name = "id") int company_id) {
        log.info("get Employee by " + role + " and " + company_id);
        List<EmployerDTO> result = cService.getEmployersByRole(role, company_id)
                .stream()
                .map(EmployerDTO::from )
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCompany(@RequestBody CompanyDTO company) {
        return new ResponseEntity<String>(
                cService.updateCompany(company.getId(), company.toCompany())+" record(s) updated.",
                HttpStatus.OK);
    }

    @PutMapping("/employers/{id}/updateName")
    public ResponseEntity<String> update(@RequestBody String  name, @PathVariable(name = "id") long emloyer_id) {
        return new ResponseEntity<String>(cService.updateEmployer(emloyer_id, name) + " record updated.", HttpStatus.OK);
    }


    @DeleteMapping("/employers/delete/{id}")
    public ResponseEntity deleteEmployer(@RequestBody String employer_id) {
        cService.deleteEmployer(Long.parseLong(employer_id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCompany(@RequestBody String company_id) {
        cService.deleteCompany(Long.parseLong(company_id));
        return ResponseEntity.ok().build();
    }


}
