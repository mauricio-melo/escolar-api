package br.com.newidea.escolar.resource;

import br.com.newidea.escolar.model.CourseEntity;
import br.com.newidea.escolar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/course")
public class CourseResource {

    @Autowired
    private CourseService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody CourseEntity course) {

        // Acionando service save
        final CourseEntity entity = service.save(course);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{courseId}")
                .buildAndExpand(entity.getCourseId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{courseId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable Long courseId, @Valid @RequestBody final CourseEntity course) {

        // Acionando service update
        final CourseEntity entity = service.update(courseId, course);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{courseId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> findById(@PathVariable final Long courseId) {

        // Efetuando busca da entidade na base dados pelo courseId
        final CourseEntity entity = service.findById(courseId);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(entity);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CourseEntity>> list() {

        // Buscando todos os recursos course
        final List<CourseEntity> entityList = service.findAll();

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<Void> delete(@PathVariable("courseId") Long courseId) {

        // Acionando service delete
        service.deleteById(courseId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }


}
