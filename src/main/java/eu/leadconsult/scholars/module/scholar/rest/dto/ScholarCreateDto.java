package eu.leadconsult.scholars.module.scholar.rest.dto;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScholarCreateDto {

    protected String name;
    protected int age;
    protected int group;
    protected Course course;
    protected ScholarType scholarType;
}
