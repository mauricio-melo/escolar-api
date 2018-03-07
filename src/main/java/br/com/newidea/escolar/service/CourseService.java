package br.com.newidea.escolar.service;

import br.com.newidea.escolar.exception.ResourceNotFoundException;
import br.com.newidea.escolar.model.CourseEntity;
import br.com.newidea.escolar.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity save(CourseEntity course){
        return courseRepository.save(course);
    }

    public CourseEntity update(Long id, CourseEntity course) {
        CourseEntity courseSaved = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", id));

        //transfere dados de course para courseSaved, ignorando o campo courseId
        BeanUtils.copyProperties(course, courseSaved, "courseId");

        return courseRepository.save(courseSaved);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public void delete(CourseEntity course) {
        courseRepository.delete(course);
    }

    public CourseEntity findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", id));
    }

    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }



}
