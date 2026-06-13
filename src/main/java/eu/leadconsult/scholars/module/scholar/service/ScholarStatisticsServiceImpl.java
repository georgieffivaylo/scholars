package eu.leadconsult.scholars.module.scholar.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import eu.leadconsult.scholars.module.scholar.repository.ScholarRepository;
import eu.leadconsult.scholars.module.scholar.repository.predicate.ScholarPredicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static eu.leadconsult.scholars.module.scholar.entity.ScholarType.STUDENT;

@Slf4j
@Service
@AllArgsConstructor
public class ScholarStatisticsServiceImpl implements ScholarStatisticsService {

    private final ScholarRepository scholarRepository;
    private final ScholarPredicate scholarPredicate;

    @Override
    public long countScholarsByScholarType(ScholarType scholarType) {
        Predicate predicate = scholarPredicate.byScholarType(scholarType);
        return scholarRepository.count(predicate);
    }

    @Override
    public long countCoursesByCourseType(Course course) {
        return scholarRepository.count(scholarPredicate.byCourseType(course));
    }

    @Override
    public List<Scholar> getStudentsForCourse(Course course) {
        BooleanExpression byScholarTypeAndCourse = scholarPredicate.byScholarType(STUDENT)
                .and(scholarPredicate.byCourseType(course));
        return (List<Scholar>) scholarRepository.findAll(byScholarTypeAndCourse);
    }

    @Override
    public List<Scholar> getStudentsForGroup(int group) {
        BooleanExpression byScholarTypeAndGroup = scholarPredicate.byScholarType(STUDENT)
                .and(scholarPredicate.byGroup(group));
        return (List<Scholar>) scholarRepository.findAll(byScholarTypeAndGroup);
    }

    @Override
    public List<Scholar> getAllForGroupAndCourse(int group, Course course) {
        Predicate byGroupAndCourse = scholarPredicate.byGroup(group).and(scholarPredicate.byCourseType(course));
        return (List<Scholar>) scholarRepository.findAll(byGroupAndCourse);
    }

    @Override
    public List<Scholar> getAllStudentsForCourseOlderThan(Course course, int age) {
        Predicate byScholarTypeAndCourseAndAge = scholarPredicate.byScholarType(STUDENT)
                .and(scholarPredicate.byCourseType(course))
                .and(scholarPredicate.byAgeGreaterThan(age));
        return (List<Scholar>) scholarRepository.findAll(byScholarTypeAndCourseAndAge);
    }
}
