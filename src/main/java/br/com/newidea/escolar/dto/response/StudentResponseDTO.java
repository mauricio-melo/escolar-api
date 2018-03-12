package br.com.newidea.escolar.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDTO {

    @ApiModelProperty(notes = "ID do aluno.", example = "1", required = true, position = 0)
    private Long studentId;

    @ApiModelProperty(notes = "nome do aluno.", example = "Jose da Silva", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "Telefone do responsavel do aluno.", example = "(11) 5526-2038", required = true, position = 2)
    private String telephone;

    @ApiModelProperty(notes = "Celular do responsavel do aluno.", example = "(11) 97314-1443", required = true, position = 3)
    private String cellphone;

    @ApiModelProperty(notes = "nome do responsavel do aluno.", example = "Maria(mãe) e Jose(pai)", required = true, position = 4)
    private String responsible;


}
