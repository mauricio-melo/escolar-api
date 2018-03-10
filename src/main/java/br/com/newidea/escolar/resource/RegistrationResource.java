package br.com.newidea.escolar.resource;

import br.com.newidea.escolar.model.RegistrationEntity;
import br.com.newidea.escolar.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/registration")
public class RegistrationResource {

    @Autowired
    private RegistrationService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody RegistrationEntity registration) {

        // Acionando service save
        final RegistrationEntity entity = service.save(registration);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{registrationId}")
                .buildAndExpand(entity.getRegistrationId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{registrationId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable Long registrationId, @Valid @RequestBody final RegistrationEntity registration) {

        // Acionando service update
        final RegistrationEntity entity = service.update(registrationId, registration);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{registrationId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrationEntity> findById(@PathVariable final Long registrationId) {

        // Efetuando busca da entidade na base dados pelo registrationId
        final RegistrationEntity entity = service.findById(registrationId);

        // Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(entity);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegistrationEntity>> list() {

        // Buscando todos os recursos registration
        final List<RegistrationEntity> entityList = service.findAll();

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("{registrationId}")
    public ResponseEntity<Void> delete(@PathVariable("registrationId") Long registrationId) {

        // Acionando service delete
        service.deleteById(registrationId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }


}
