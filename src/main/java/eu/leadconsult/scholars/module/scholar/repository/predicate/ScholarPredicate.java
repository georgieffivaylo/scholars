package eu.leadconsult.scholars.module.scholar.repository.predicate;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.QScholar;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import org.springframework.stereotype.Component;

@Component
public class ScholarPredicate {

    private final QScholar qScholar;

    public ScholarPredicate() {
        qScholar = QScholar.scholar;
    }

    public BooleanExpression byScholarType(ScholarType scholarType) {
        return qScholar.scholarType.eq(scholarType);
    }

    public BooleanExpression byCourseType(Course course) {
        return qScholar.course.eq(course);
    }

    public BooleanExpression byGroup(int group) {
        return qScholar.group.eq(group);
    }

    public BooleanExpression byAgeGreaterThan(int age) {
        return qScholar.age.gt(age);
    }
}
