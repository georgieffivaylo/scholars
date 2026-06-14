package eu.leadconsult.scholars.module.scholar.dto.common;

import eu.leadconsult.scholars.module.scholar.entity.enums.Course;
import eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType;
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
