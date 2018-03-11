package br.com.newidea.escolar.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CourseDTO {

    private Long courseId;
    private String name;
    private BigDecimal value;
}
