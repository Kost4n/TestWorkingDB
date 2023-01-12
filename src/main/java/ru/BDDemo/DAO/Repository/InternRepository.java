package ru.BDDemo.DAO.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.BDDemo.Company.Employers.Intern;

public interface InternRepository extends CrudRepository<Intern, Long> {
}
