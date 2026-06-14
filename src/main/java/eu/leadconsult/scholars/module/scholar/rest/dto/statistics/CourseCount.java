package eu.leadconsult.scholars.module.scholar.rest.dto.statistics;

import eu.leadconsult.scholars.module.scholar.entity.enums.Course;

public record CourseCount(Course course, long count) {
}
