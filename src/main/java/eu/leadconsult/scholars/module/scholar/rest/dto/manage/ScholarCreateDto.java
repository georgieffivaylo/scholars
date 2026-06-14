package eu.leadconsult.scholars.module.scholar.rest.dto.manage;

import eu.leadconsult.scholars.module.scholar.entity.enums.Course;
import eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScholarCreateDto {

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    protected String name;

    protected int age;

    protected int group;

    @NotNull(message = "Course cannot be null")
    protected Course course;

    @NotNull(message = "Scholar type cannot be null")
    protected ScholarType scholarType;
}
