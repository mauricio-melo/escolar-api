package br.com.newidea.escolar.resource;

import br.com.newidea.escolar.model.StudentEntity;
import br.com.newidea.escolar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/student")
public class StudentResource {

    @Autowired
    private StudentService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody StudentEntity student) {

        // Acionando service save
        final StudentEntity entity = service.save(student);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{studentId}")
                .buildAndExpand(entity.getStudentId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{studentId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable Long studentId, @Valid @RequestBody final StudentEntity student) {

        // Acionando service update
        final StudentEntity entity = service.update(studentId, student);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{studentId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentEntity> findById(@PathVariable final Long studentId) {

        // Efetuando busca da entidade na base dados pelo studentId
        final StudentEntity entity = service.findById(studentId);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(entity);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> list() {

        // Buscando todos os recursos student
        final List<StudentEntity> entityList = service.findAll();

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Void> delete(@PathVariable("studentId") Long studentId) {

        // Acionando service delete
        service.deleteById(studentId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }




}
