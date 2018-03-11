package br.com.newidea.escolar.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDTO {

    private Long studentId;

    private String name;

    private String telephone;

    private String cellphone;

    private String responsible;


}
