package eu.leadconsult.scholars.module.scholar.dto.statistics;

import eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType;

public record ScholarCount(ScholarType scholarType, long count) {
}
