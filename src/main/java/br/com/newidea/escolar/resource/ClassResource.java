package br.com.newidea.escolar.resource;

import br.com.newidea.escolar.model.ClassEntity;
import br.com.newidea.escolar.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/class")
public class ClassResource {

    @Autowired
    private ClassService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody ClassEntity classEntity) {

        // Acionando service save
        final ClassEntity entity = service.save(classEntity);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{classId}")
                .buildAndExpand(entity.getClassId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{classId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable Long classId, @Valid @RequestBody final ClassEntity classEntity) {

        // Acionando service update
        final ClassEntity entity = service.update(classId, classEntity);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{classId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassEntity> findById(@PathVariable final Long classId) {

        // Efetuando busca da entidade na base dados pelo classId
        final ClassEntity entity = service.findById(classId);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(entity);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClassEntity>> list() {

        // Buscando todos os recursos classEntity
        final List<ClassEntity> entityList = service.findAll();

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("{classId}")
    public ResponseEntity<Void> delete(@PathVariable("classId") Long classId) {

        // Acionando service delete
        service.deleteById(classId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }


}
