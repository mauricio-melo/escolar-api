package br.com.newidea.escolar.service;

import br.com.newidea.escolar.dto.StudentDTO;
import br.com.newidea.escolar.exception.ResourceNotFoundException;
import br.com.newidea.escolar.model.StudentEntity;
import br.com.newidea.escolar.repository.StudentRepository;
import br.com.newidea.escolar.translator.StudentTranslator;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentTranslator translator;

    @Autowired
    private StudentRepository repository;

    public StudentEntity save(@NonNull final StudentDTO dto){

        // Tradução de DTO para Entity
        StudentEntity entity = translator.toEntity(dto);

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    public StudentEntity update(@NonNull final StudentDTO dto) {

        // Obtendo o student pelo id
        StudentEntity entity = findById(dto.getStudentId());

        // Traduzindo DTO para Entity
        entity = translator.toEntity(dto, entity);

        // Salvando
        entity = repository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentEntity findById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", id));
    }

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

}

