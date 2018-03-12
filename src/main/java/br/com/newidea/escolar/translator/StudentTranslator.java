package br.com.newidea.escolar.translator;

import br.com.newidea.escolar.dto.StudentDTO;
import br.com.newidea.escolar.dto.request.StudentRequestDTO;
import br.com.newidea.escolar.dto.response.StudentResponseDTO;
import br.com.newidea.escolar.model.StudentEntity;
import br.com.newidea.escolar.model.util.Address;
import br.com.newidea.escolar.model.util.IdentityCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.reflections.util.ConfigurationBuilder.build;

@Component
public class StudentTranslator {

    //Traduz o que veio do request para o DTO
    public StudentDTO toDTO(StudentRequestDTO requestDTO) {
        return StudentDTO.builder()
                .studentId(requestDTO.getStudentId())
                .name(requestDTO.getName())
                .scholarity(requestDTO.getScholarity())
                .telephone(requestDTO.getTelephone())
                .cellphone(requestDTO.getCellphone())
                .bloodType(requestDTO.getBloodType())
                .rg(requestDTO.getRg())
                .responsible(requestDTO.getResponsible())
                .emissionDate(requestDTO.getEmissionDate())
                .local(requestDTO.getLocal())
                .cpf(requestDTO.getCpf())
                .gender(requestDTO.getGender())
                .street(requestDTO.getStreet())
                .neighborhood(requestDTO.getNeighborhood())
                .city(requestDTO.getCity())
                .zipCode(requestDTO.getZipCode())
                .state(requestDTO.getState())
                .build();
    }

    //Traduz o DTO para entity, recebendo o DTO por parametro
    public StudentEntity toEntity(StudentDTO dto) {
        return toEntity(dto, StudentEntity.builder().build());
    }

    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public StudentEntity toEntity(StudentDTO dto, StudentEntity entity) {

        IdentityCard card = IdentityCard.builder()
                .rg(dto.getRg())
                .cpf(dto.getCpf())
                .emissionDate(dto.getEmissionDate())
                .gender(dto.getGender())
                .local(dto.getLocal())
                .responsible(dto.getResponsible())
                .build();

        Address address = Address.builder()
                .street(dto.getStreet())
                .neighborhood(dto.getNeighborhood())
                .zipCode(dto.getZipCode())
                .state(dto.getState())
                .city(dto.getCity())
                .build();

        entity.setStudentId(dto.getStudentId());
        entity.setName(dto.getName());
        entity.setScholarity(dto.getScholarity());
        entity.setTelephone(dto.getTelephone());
        entity.setCellphone(dto.getCellphone());
        entity.setBloodType(dto.getBloodType());
        entity.setIdentityCard(card);
        entity.setAddress(address);

        return entity;

    }

    //Traduz a entity para a o response
    public StudentResponseDTO toResponse(StudentEntity entity) {
        return StudentResponseDTO.builder()
                .studentId(entity.getStudentId())
                .name(entity.getName())
                .telephone(entity.getTelephone())
                .cellphone(entity.getCellphone())
                .responsible(entity.getIdentityCard().getResponsible())
                .build();
    }

    //TODO: Pedir ao Fabio para explicar o lambda
    //Traduz uma lista de entity para uma lista de response
    public List<StudentResponseDTO> toResponse(List<StudentEntity> entityList) {
        List<StudentResponseDTO> responseDTOList = new ArrayList<StudentResponseDTO>();
        entityList.forEach(
                studentEntity ->
                        responseDTOList.add(toResponse(studentEntity))
        );
        return responseDTOList;
    }
}
