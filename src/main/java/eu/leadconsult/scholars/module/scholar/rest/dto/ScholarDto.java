package eu.leadconsult.scholars.module.scholar.rest.dto;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScholarDto {

    private Long id;

    private String name;

    private Integer age;

    private Integer group;

    private Course course;

    private ScholarType scholarType = ScholarType.STUDENT;
}
