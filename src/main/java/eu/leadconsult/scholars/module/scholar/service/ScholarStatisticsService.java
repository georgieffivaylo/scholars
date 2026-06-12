package eu.leadconsult.scholars.module.scholar.service;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;

import java.util.List;

public interface ScholarStatisticsService {

    int countScholarsByScholarType(ScholarType scholarType);

    int countCoursesByCourseType(Course course);

    List<Scholar> getScholarsForCourse(ScholarType scholarType, Course course);

    List<Scholar> getScholarsForGroup(ScholarType scholarType, int group);
}
