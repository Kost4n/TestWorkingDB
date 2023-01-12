package ru.BDDemo.DAO.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.BDDemo.Company.Employers.Barista;

@Repository
public interface BaristaRepository extends CrudRepository<Barista, Long> {

}
