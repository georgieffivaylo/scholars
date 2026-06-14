package eu.leadconsult.scholars.module.scholar.dto.manage;

import eu.leadconsult.scholars.module.scholar.entity.enums.Course;
import eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ScholarEditDto extends ScholarCreateDto {

    @NotNull(message = "Id cannot be null")
    private Long id;

    public ScholarEditDto(Long id, String name, int age, int group, Course course, ScholarType scholarType) {
        super(name, age, group, course, scholarType);
        this.id = id;
    }
}
