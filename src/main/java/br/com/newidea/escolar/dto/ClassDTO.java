package br.com.newidea.escolar.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClassDTO {

    private Long classId;

    private String period;

    private Date startDate;

    private Date endDate;

    private String startHour;

    private int vacancy;

    private Long courseId;
}
