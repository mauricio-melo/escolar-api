package br.com.newidea.escolar.repository;

import br.com.newidea.escolar.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
