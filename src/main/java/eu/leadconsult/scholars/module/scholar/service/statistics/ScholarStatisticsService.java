package eu.leadconsult.scholars.module.scholar.service.statistics;

import eu.leadconsult.scholars.module.scholar.entity.enums.Course;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType;

import java.util.List;

public interface ScholarStatisticsService {

    long countScholarsByScholarType(ScholarType scholarType);

    long countCoursesByCourseType(Course course);

    List<Scholar> getStudentsForCourse(Course course);

    List<Scholar> getStudentsForGroup(int group);

    List<Scholar> getAllForGroupAndCourse(int group, Course course);

    List<Scholar> getAllStudentsForCourseOlderThan(Course course, int age);
}
