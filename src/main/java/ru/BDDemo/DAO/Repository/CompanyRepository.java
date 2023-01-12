package ru.BDDemo.DAO.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.BDDemo.Company.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Company SET name = :company WHERE id = :id")
    Integer updateNameById( String company, long id);

}
