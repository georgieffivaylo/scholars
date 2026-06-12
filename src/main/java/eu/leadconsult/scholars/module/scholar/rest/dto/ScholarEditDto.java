package eu.leadconsult.scholars.module.scholar.rest.dto;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ScholarEditDto extends ScholarCreateDto {

    private Long id;

    public ScholarEditDto(Long id, String name, int age, int group, Course course, ScholarType scholarType) {
        super(name, age, group, course, scholarType);
        this.id = id;
    }
}
