package br.com.newidea.escolar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString(of = {"classId"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class")

public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    private String period;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    private String startHour;
    private int vacancy;

    //TODO: VER COM O FABIO O PORQUE TA VINDO NULL
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ManyToMany
    @JoinTable(name = "registration", joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> student;

}
