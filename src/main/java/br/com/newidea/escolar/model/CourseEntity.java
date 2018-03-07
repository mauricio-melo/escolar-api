package br.com.newidea.escolar.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@ToString(of = {"studentId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {

    private Long courseId;
    private String name;
    private BigDecimal value;

    private List<ClassEntity> listClass;

}
