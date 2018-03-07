package br.com.newidea.escolar.repository;

import br.com.newidea.escolar.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
