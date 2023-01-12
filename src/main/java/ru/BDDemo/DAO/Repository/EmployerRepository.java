package ru.BDDemo.DAO.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.BDDemo.Company.Company;
import ru.BDDemo.Company.Employers.CFRole;
import ru.BDDemo.Company.Employers.Employer;

import java.util.List;

@Repository
public interface EmployerRepository extends CrudRepository<Employer<CFRole>, Long> {
    List<Employer> findByRoleAndCompany(CFRole role, Company company);

    @Transactional
    @Modifying
    @Query("UPDATE Employer SET name = :newName WHERE id = :id")
    Integer updateNameById( String newName, long id);

}
