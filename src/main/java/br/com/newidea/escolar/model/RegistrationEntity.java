package br.com.newidea.escolar.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@ToString(of = {"registrationId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name="student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name="class_id")
    private ClassEntity classEntity;

    @PrePersist
    public void beforeInsert() {
        this.registrationDate = new Date();
    }
}
