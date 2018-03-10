package br.com.newidea.escolar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@ToString(of = {"courseId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;
    private BigDecimal value;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<ClassEntity> classEntity;

}
