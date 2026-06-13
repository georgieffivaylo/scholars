package eu.leadconsult.scholars.module.scholar.rest;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import eu.leadconsult.scholars.module.scholar.rest.dto.CourseCount;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarCount;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarResultDto;
import eu.leadconsult.scholars.module.scholar.service.ScholarStatisticsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/scholars/statistics")
public class ScholarStatisticsController {

    private final ScholarStatisticsService scholarStatisticsService;
    private final ModelMapper modelMapper;

    @GetMapping("scholars-by-type")
    public ResponseEntity<ScholarCount> scholarCount(@RequestParam ScholarType scholarType) {
        long count = scholarStatisticsService.countScholarsByScholarType(scholarType);
        return ResponseEntity.status(CREATED).body(new ScholarCount(scholarType, count));
    }

    @GetMapping("courses-by-type")
    public ResponseEntity<CourseCount> courseCount(@RequestParam Course course) {
        long count = scholarStatisticsService.countCoursesByCourseType(course);
        return ResponseEntity.ok(new CourseCount(course, count));
    }

    @GetMapping("students/for-corse/{course}")
    public ResponseEntity<ScholarResultDto> getStudentsByCourse(@PathVariable Course course) {
        List<ScholarDto> studentsForCourse = scholarStatisticsService.getStudentsForCourse(course)
                .stream().map(scholar -> modelMapper.map(scholar, ScholarDto.class)).toList();
        return ResponseEntity.ok(new ScholarResultDto(studentsForCourse));
    }

    @GetMapping("students/for-group/{group}")
    public ResponseEntity<ScholarResultDto> getStudentsByGroup(@PathVariable int group) {
        List<ScholarDto> studentsForGroup = scholarStatisticsService.getStudentsForGroup(group)
                .stream().map(scholar -> modelMapper.map(scholar, ScholarDto.class)).toList();
        return ResponseEntity.ok(new ScholarResultDto(studentsForGroup));
    }

    @GetMapping("all/for-group/{group}/for-course/{course}")
    public ResponseEntity<ScholarResultDto> getAllByGroupAndCourse(@PathVariable int group, @PathVariable Course course) {
        List<ScholarDto> studentsForGroupAndCourse = scholarStatisticsService.getAllForGroupAndCourse(group, course)
                .stream().map(scholar -> modelMapper.map(scholar, ScholarDto.class)).toList();
        return ResponseEntity.ok(new ScholarResultDto(studentsForGroupAndCourse));
    }

    @GetMapping("students/older-than/{age}/for-course/{course}")
    public ResponseEntity<ScholarResultDto> getStudentsByCourseOlderThan(@PathVariable Course course, @PathVariable int age) {
        List<ScholarDto> studentsForGroupAndCourse = scholarStatisticsService.getAllStudentsForCourseOlderThan(course, age)
                .stream().map(scholar -> modelMapper.map(scholar, ScholarDto.class)).toList();
        return ResponseEntity.ok(new ScholarResultDto(studentsForGroupAndCourse));
    }
}
