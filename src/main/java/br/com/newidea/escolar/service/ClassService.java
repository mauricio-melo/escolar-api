package br.com.newidea.escolar.service;

import br.com.newidea.escolar.exception.ResourceNotFoundException;
import br.com.newidea.escolar.model.ClassEntity;
import br.com.newidea.escolar.repository.ClassRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public ClassEntity save(ClassEntity classEntity){
        return classRepository.save(classEntity);
    }

    public ClassEntity update(Long id, ClassEntity classEntity) {
        ClassEntity classSaved = classRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class", "classId", id));

        //transfere dados de classEntity para classSaved, ignorando o campo classId
        BeanUtils.copyProperties(classEntity, classSaved, "classId");

        return classRepository.save(classSaved);
    }

    public void deleteById(Long id) {
        classRepository.deleteById(id);
    }

    public void delete(ClassEntity classEntity) {
        classRepository.delete(classEntity);
    }

    public ClassEntity findById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class", "classId", id));
    }

    public List<ClassEntity> findAll() {
        return classRepository.findAll();
    }



}
