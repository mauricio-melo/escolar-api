package br.com.newidea.escolar.repository;

import br.com.newidea.escolar.model.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {

}
