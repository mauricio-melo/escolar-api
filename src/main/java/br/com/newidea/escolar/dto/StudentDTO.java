package br.com.newidea.escolar.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class StudentDTO {

    private Long studentId;
    private String name;
    private String scholarity;
    private String telephone;
    private String cellphone;
    private String bloodType;
    private String rg;
    private String responsible;
    private Date emissionDate;
    private String local;
    private String cpf;
    private String gender;
    private String street;
    private String neighborhood;
    private String city;
    private String zipCode;
    private String state;

}
