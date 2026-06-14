package eu.leadconsult.scholars.module.scholar.entity;

import eu.leadconsult.scholars.module.scholar.entity.enums.Course;
import eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "scholars")
public class Scholar {

    @Id
    @SequenceGenerator(name = "scholarSequence", sequenceName = "SEQ_SCHOLARS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scholarSequence")
    private Long id;

    private String name;

    private Integer age;

    @Column(name = "scholar_group")
    private Integer group;

    @Enumerated(EnumType.STRING)
    private Course course;

    @Enumerated(EnumType.STRING)
    private ScholarType scholarType = ScholarType.STUDENT;
}
