package br.com.newidea.escolar.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
