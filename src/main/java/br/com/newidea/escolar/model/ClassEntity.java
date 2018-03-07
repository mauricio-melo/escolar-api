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
@Table(name = "class")
public class ClassEntity {

    private Long classId;
    private String period;
    private Date startDate;
    private Date endDate;
    private String startHour;
    private String timeTable;
    private int vacancy;
    private CourseEntity course;

}
