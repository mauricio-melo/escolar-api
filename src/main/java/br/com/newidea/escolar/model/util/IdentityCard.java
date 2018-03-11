package br.com.newidea.escolar.model.util;

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

    @Column(nullable = false)
    private String responsible;

    @Temporal(TemporalType.DATE)
    @Column(name = "emission_date", nullable = false)
    private Date emissionDate;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String gender;

}
