package br.com.newidea.escolar.resource;

import br.com.newidea.escolar.dto.StudentDTO;
import br.com.newidea.escolar.dto.request.StudentRequestDTO;
import br.com.newidea.escolar.dto.response.StudentResponseDTO;
import br.com.newidea.escolar.model.StudentEntity;
import br.com.newidea.escolar.service.StudentService;
import br.com.newidea.escolar.translator.StudentTranslator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Aluno", description = "Operações disponíveis para o recurso aluno")
public class StudentResource {

    @Autowired
    private StudentTranslator translator;

    @Autowired
    private StudentService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso student", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody StudentRequestDTO requestDTO) {

        // Traduzindo requisição recebida para DTO
        final StudentDTO studentDTO = translator.toDTO(requestDTO);

        // Acionando service create
        final StudentEntity entity = service.save(studentDTO);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{studentId}")
                .buildAndExpand(entity.getStudentId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualização de um recurso student", responseReference = "200 = Recurso atualizado com sucesso.")
    public ResponseEntity<StudentEntity> update(@Valid @RequestBody final StudentRequestDTO requestDTO) {

        //Traduzindo requisição recebida para DTO
        final StudentDTO studentDTO = translator.toDTO(requestDTO);

        //Acionando service update
        final StudentEntity entity = service.update(studentDTO);

        //retornando a responseActivity com o status ok
        return ResponseEntity.ok(entity);
    }

    @GetMapping(path = "/{studentId}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa de um recurso student em específico", response = StudentResponseDTO.class)
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable final Long studentId) {

        //Efetuando busca da entidade na base dados pelo id
        final StudentEntity entity = service.findById(studentId);

        //Traduzindo Entity para Response
        final StudentResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos os student's", response = StudentResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<StudentResponseDTO>> list() {

        //Buscando todos os recursos tattoo para Requisição recebida
        final List<StudentEntity> entityList = service.findAll();

        //Traduzindo entity para response
        final List<StudentResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Void> delete(@PathVariable("studentId") Long studentId) {

        // Acionando service delete
        service.delete(studentId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }




}
