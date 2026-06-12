package eu.leadconsult.scholars.module.scholar.service;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import eu.leadconsult.scholars.module.scholar.repository.ScholarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ScholarStatisticsServiceImpl implements ScholarStatisticsService {

    private final ScholarRepository scholarRepository;

    @Override
    public int countScholarsByScholarType(ScholarType scholarType) {
        return scholarRepository.countByScholarType(scholarType.name());
    }

    @Override
    public int countCoursesByCourseType(Course course) {
        return scholarRepository.countByCourseType(course.name());
    }

    @Override
    public List<Scholar> getScholarsForCourse(ScholarType scholarType, Course course) {
        return scholarRepository.findAllByScholarTypeAndCourse(scholarType, course);
    }

    @Override
    public List<Scholar> getScholarsForGroup(ScholarType scholarType, int group) {
        return scholarRepository.findAllByScholarTypeAndGroup(scholarType, group);
    }
}
