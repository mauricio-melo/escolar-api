package br.com.newidea.escolar.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@ToString(of = {"studentId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class RegistrationEntity {

    private Long registrationId;
    private StudentEntity student;
    private ClassEntity classEntity;
    private Date registrationDate;





}
