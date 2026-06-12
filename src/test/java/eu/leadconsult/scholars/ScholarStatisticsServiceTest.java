package eu.leadconsult.scholars;

import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import eu.leadconsult.scholars.module.scholar.service.ScholarStatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static eu.leadconsult.scholars.module.scholar.entity.Course.MAIN;
import static eu.leadconsult.scholars.module.scholar.entity.Course.SECONDARY;
import static eu.leadconsult.scholars.module.scholar.entity.ScholarType.STUDENT;
import static eu.leadconsult.scholars.module.scholar.entity.ScholarType.TEACHER;
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
		assertEquals(2, scholarStatisticsService.countCoursesByCourseType(MAIN));
	}

	@Test
	void getScholarsForCourse_ShouldReturnAllScholarsForCourse_WhenCoursesIsProvided() {
		List<Scholar> scholarsForMainCourse = scholarStatisticsService.getScholarsForCourse(ScholarType.STUDENT, MAIN);
		boolean allInMainCourse = scholarsForMainCourse.stream().allMatch(scholar -> scholar.getCourse().equals(MAIN));
		assertTrue(allInMainCourse);

		List<Scholar> scholarsForSecondaryCourse = scholarStatisticsService.getScholarsForCourse(STUDENT, SECONDARY);
		boolean allInSecondaryCourse = scholarsForSecondaryCourse.stream().allMatch(scholar -> scholar.getCourse().equals(SECONDARY));
		assertTrue(allInSecondaryCourse);
	}

	@Test
	void getScholarsForGroup_ShouldReturnAllScholarsForGroup_WhenGroupIsProvided() {
		List<Scholar> scholarsForGroupOne = scholarStatisticsService.getScholarsForGroup(ScholarType.STUDENT, 1);
		boolean allInGroupOne = scholarsForGroupOne.stream().allMatch(scholar -> scholar.getGroup() == 1);
		assertTrue(allInGroupOne);

		List<Scholar> scholarsForGroupTwo = scholarStatisticsService.getScholarsForGroup(STUDENT, 2);
		boolean allInGroupTwo = scholarsForGroupTwo.stream().allMatch(scholar -> scholar.getGroup() == 2);
		assertTrue(allInGroupTwo);
	}
}
