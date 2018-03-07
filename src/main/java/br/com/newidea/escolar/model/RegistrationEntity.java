package br.com.newidea.escolar.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@ToString(of = {"studentId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    private ClassEntity classEntity;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "registration_date")
    private Date registrationDate;

    @PrePersist
    public void beforeInsert() {
        this.registrationDate = new Date();
    }
}
