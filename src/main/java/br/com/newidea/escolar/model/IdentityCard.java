package br.com.newidea.escolar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class IdentityCard {

    @Column(nullable = false)
    private String rg;

    @Column(name = "mother_name", nullable = false)
    private String motherName;

    @Column(name = "father_name", nullable = false)
    private String fatherName;

    //@Temporal(TemporalType.DATE)
    //@Column(name = "emission_date", nullable = false)
    //private Date emissionDate;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String gender;

}
