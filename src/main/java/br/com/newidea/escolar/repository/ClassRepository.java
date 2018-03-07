package br.com.newidea.escolar.repository;

import br.com.newidea.escolar.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

}
