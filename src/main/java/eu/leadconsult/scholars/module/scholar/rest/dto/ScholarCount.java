package eu.leadconsult.scholars.module.scholar.rest.dto;

import eu.leadconsult.scholars.module.scholar.entity.ScholarType;

public record ScholarCount(ScholarType scholarType, long count) {
}
