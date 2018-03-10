package br.com.newidea.escolar.model;

import br.com.newidea.escolar.model.util.Address;
import br.com.newidea.escolar.model.util.BloodType;
import br.com.newidea.escolar.model.util.IdentityCard;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@ToString(of = {"studentId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String scholarity;

    private String telephone;

    @Column(nullable = false)
    private String cellphone;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Embedded
    private IdentityCard identityCard;

    @Embedded
    private Address address;

    //@OneToMany(mappedBy = "student")
    //private List<RegistrationEntity> registration;

}
