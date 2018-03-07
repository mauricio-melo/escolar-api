package br.com.newidea.escolar.service;

import br.com.newidea.escolar.exception.ResourceNotFoundException;
import br.com.newidea.escolar.model.StudentEntity;
import br.com.newidea.escolar.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity save(StudentEntity student){
        return studentRepository.save(student);
    }

    public StudentEntity update(Long id, StudentEntity student) {
        StudentEntity studentSaved = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", id));

        //transfere dados de student para studentSaved, ignorando o campo studentId
        BeanUtils.copyProperties(student, studentSaved, "studentId");

        return studentRepository.save(studentSaved);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void delete(StudentEntity student) {
        studentRepository.delete(student);
    }

    public StudentEntity findById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", id));
    }


    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

}

