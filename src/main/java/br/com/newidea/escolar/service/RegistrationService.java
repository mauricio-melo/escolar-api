package br.com.newidea.escolar.service;

import br.com.newidea.escolar.exception.ResourceNotFoundException;
import br.com.newidea.escolar.model.RegistrationEntity;
import br.com.newidea.escolar.repository.RegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public RegistrationEntity save(RegistrationEntity registration){
        return registrationRepository.save(registration);
    }

    public RegistrationEntity update(Long id, RegistrationEntity registration) {
        RegistrationEntity registrationSaved = registrationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration", "registrationId", id));

        //transfere dados de registration para registrationSaved, ignorando o campo registrationId
        BeanUtils.copyProperties(registration, registrationSaved, "registrationId");

        return registrationRepository.save(registrationSaved);
    }

    public void deleteById(Long id) {
        registrationRepository.deleteById(id);
    }

    public void delete(RegistrationEntity registration) {
        registrationRepository.delete(registration);
    }

    public RegistrationEntity findById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration", "registrationId", id));
    }

    public List<RegistrationEntity> findAll() {
        return registrationRepository.findAll();
    }



}
