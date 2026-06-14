package eu.leadconsult.scholars.statistics;

import eu.leadconsult.scholars.SpringConfigInitTest;
import eu.leadconsult.scholars.module.scholar.entity.enums.Course;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.service.statistics.ScholarStatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static eu.leadconsult.scholars.module.scholar.entity.enums.Course.MAIN;
import static eu.leadconsult.scholars.module.scholar.entity.enums.Course.SECONDARY;
import static eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType.STUDENT;
import static eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType.TEACHER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScholarStatisticsServiceTest extends SpringConfigInitTest {

    @Autowired
    private ScholarStatisticsService scholarStatisticsService;

    @Test
    void countScholarsByScholarType_ShouldReturnCorrectCount_WhenScholarsExist() {
        assertEquals(1, scholarStatisticsService.countScholarsByScholarType(STUDENT));
        assertEquals(1, scholarStatisticsService.countScholarsByScholarType(TEACHER));
    }

    @Test
    void countCoursesByCourseType_ShouldReturnCorrectCoursesCount_WhenCoursesExist() {
        assertEquals(1, scholarStatisticsService.countCoursesByCourseType(MAIN));
        assertEquals(1, scholarStatisticsService.countCoursesByCourseType(SECONDARY));
    }

    @Test
    void getStudentsForCourse_ShouldReturnAllStudentsForCourse_WhenCoursesIsProvided() {
        List<Scholar> scholarsForMainCourse = scholarStatisticsService.getStudentsForCourse(MAIN);
        boolean allInMainCourse = scholarsForMainCourse.stream().allMatch(scholar -> scholar.getCourse().equals(MAIN));
        assertTrue(allInMainCourse);

        List<Scholar> scholarsForSecondaryCourse = scholarStatisticsService.getStudentsForCourse(SECONDARY);
        boolean allInSecondaryCourse = scholarsForSecondaryCourse.stream().allMatch(scholar -> scholar.getCourse().equals(SECONDARY));
        assertTrue(allInSecondaryCourse);
    }

    @Test
    void getStudentsForGroup_ShouldReturnAllStudentsForGroup_WhenGroupIsProvided() {
        List<Scholar> scholarsForGroupOne = scholarStatisticsService.getStudentsForGroup(1);
        boolean allInGroupOne = scholarsForGroupOne.stream().allMatch(scholar -> scholar.getGroup() == 1);
        assertTrue(allInGroupOne);

        List<Scholar> scholarsForGroupTwo = scholarStatisticsService.getStudentsForGroup(2);
        boolean allInGroupTwo = scholarsForGroupTwo.stream().allMatch(scholar -> scholar.getGroup() == 2);
        assertTrue(allInGroupTwo);
    }

    @Test
    void getAllForGroupAndCourse_ShouldReturnAllMatchingScholars_WhenGroupAndCourseIsProvided() {
        int group = 1;
        Course course = SECONDARY;
        List<Scholar> scholarsForGroupOne = scholarStatisticsService.getAllForGroupAndCourse(group, course);
        boolean allInGroupOneAndSecondaryCourse = scholarsForGroupOne.stream().allMatch(scholar
                -> scholar.getGroup() == group && scholar.getCourse().equals(course));
        assertTrue(allInGroupOneAndSecondaryCourse);
    }

    @Test
    void getAllStudentsForCourseOlderThan_ShouldReturnAllMatchingScholars_WhenGroupAndCourseIsProvided() {
        Course course = MAIN;
        int age = 18;
        List<Scholar> scholarsForGroupOne = scholarStatisticsService.getAllStudentsForCourseOlderThan(course, age);
        boolean allInGroupOneAndSecondaryCourse = scholarsForGroupOne.stream().allMatch(scholar
                -> scholar.getCourse() == course && scholar.getAge() > age);
        assertTrue(allInGroupOneAndSecondaryCourse);
    }
}
