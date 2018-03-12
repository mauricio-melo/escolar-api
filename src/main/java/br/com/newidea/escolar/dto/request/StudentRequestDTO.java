package br.com.newidea.escolar.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

    @ApiModelProperty(notes = "ID do aluno.", example = "1", required = true, position = 0)
    private Long studentId;

    @NotNull(message = "Campo \"name\" precisa ser informado.")
    @ApiModelProperty(notes = "Nome do aluno.", example = "João da Silva.", required = true, position = 1)
    private String name;

    @NotNull(message = "Campo \"scholarity\" precisa ser informado.")
    @ApiModelProperty(notes = "Escolaridade do aluno.", example = "Ensino Médio Completo", required = true, position = 2)
    private String scholarity;

    @ApiModelProperty(notes = "Telefone de algum responsavel do aluno.", example = "(11)5526-2043", position = 3)
    private String telephone;

    @NotNull(message = "Campo \"cellphone\" precisa ser informado.")
    @ApiModelProperty(notes = "Celular de algum responsavel do aluno.", example = "(11) 97314-1432", required = true, position = 4)
    private String cellphone;

    @NotNull(message = "Campo \"bloodType\" precisa ser informado.")
    @ApiModelProperty(notes = "Tipo sanguíneo do aluno.", example = "A_POSITIVO", required = true, position = 5)
    private String bloodType;

    @NotNull(message = "Campo \"RG\" precisa ser informado.")
    @ApiModelProperty(notes = "RG do aluno.", example = "37.623.652-7", required = true, position = 6)
    private String rg;

    @NotNull(message = "Campo \"resposible\" precisa ser informado.")
    @ApiModelProperty(notes = "Nome do responsavel do aluno.", example = "Clementina(avó)", required = true, position = 7)
    private String responsible;

    @NotNull(message = "Campo \"emissionDate\" precisa ser informado.")
    @ApiModelProperty(notes = "Data de emissão do RG do aluno.", example = "1998-02-06", required = true, position = 8)
    private Date emissionDate;

    @NotNull(message = "Campo \"local\" precisa ser informado.")
    @ApiModelProperty(notes = "Local do RG do aluno.", example = "São Paulo", required = true, position = 9)
    private String local;

    @NotNull(message = "Campo \"cpf\" precisa ser informado.")
    @ApiModelProperty(notes = "CPF do aluno.", example = "445.490.898-04", required = true, position = 10)
    private String cpf;

    @NotNull(message = "Campo \"gender\" precisa ser informado.")
    @ApiModelProperty(notes = "Sexo do aluno.", example = "Masculino", required = true, position = 11)
    private String gender;

    @NotNull(message = "Campo \"street\" precisa ser informado.")
    @ApiModelProperty(notes = "Rua do aluno.", example = "Rua Joaquim Floriano, 1000", required = true, position = 12)
    private String street;

    @NotNull(message = "Campo \"neighborhood\" precisa ser informado.")
    @ApiModelProperty(notes = "Bairro do aluno.", example = "Itaim Bibi", required = true, position = 13)
    private String neighborhood;

    @NotNull(message = "Campo \"city\" precisa ser informado.")
    @ApiModelProperty(notes = "Cidade do aluno.", example = "São Paulo", required = true, position = 14)
    private String city;

    @NotNull(message = "Campo \"zipCode\" precisa ser informado.")
    @ApiModelProperty(notes = "Cep do aluno.", example = "04856-285", required = true, position = 15)
    private String zipCode;

    @NotNull(message = "Campo \"state\" precisa ser informado.")
    @ApiModelProperty(notes = "Estado do aluno.", example = "São Paulo", required = true, position = 16)
    private String state;

}